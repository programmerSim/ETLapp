package com.data.etldata.service;

import com.data.etldata.dto.CsvContentDto;
import com.data.etldata.dto.ExtractContentDto;
import com.data.etldata.mapper.DataMapper;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CsvService implements DataService {

    private final DataMapper mapper;

    @Autowired
    public CsvService(DataMapper mapper) {
        this.mapper = mapper;
    }

    // 실행
    @Override
    public void action() {
        // 원본데이터 경로
        String dirPath = "/Users/jihunsim/Documents/dataFolder/원본데이터/";

        // CSV데이터 경로
        String csvFilePath = "/Users/jihunsim/Documents/dataFolder/CSV파일/";

        // 파일 선택
        selectFileToCsv(dirPath, "");

        // CSV 파일 읽기
        loadCsvFile(csvFilePath);

        // 출력 날짜 입력
        inputTime();
    }

    // 파일 선택
    @Override
    public void selectFileToCsv(String dirPath, String name) {
        int fileCount = 0;
        String folderName = name;

        File path = new File(dirPath);
        File[] files = path.listFiles();

        if (files != null) {
            Arrays.parallelSort(files);

            // 전체 파일 개수 만큼 반복
            for (File file : files) {

                // 파일이면
                if (file.isFile() && file.getName().endsWith(".dat")) {
                    String fileName = file.getName();
                    fileCount++;

                    try {
                        // 파일 읽기
                        List<CsvContentDto> dataList = readFileToCsv(file);

                        log.info("파일경로 : " + file);
                        log.info("파일명 : " + fileName);
                        log.info("폴더명 : " + folderName);

                        // CSV 파일 쓰기
                        writeDataToCsv(dataList, folderName);
                        log.info(fileName + " : CSV 파일 쓰기 완료");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // 폴더면
                } else {
                    folderName = file.getName();
                    log.info("폴더명 : " + folderName);
                    selectFileToCsv(file.getPath(), folderName);  // 재귀함수 호출
                }
            }

            if (fileCount != 0) {
                log.info(".dat 파일 갯수 : " + fileCount + "개");
            } else {
                log.info("CSV 파일 쓰기 완료");
            }
        }
    }

    // 파일 읽기
    @Override
    public List<CsvContentDto> readFileToCsv(File file) {
        List<CsvContentDto> dataList = new ArrayList<>();
        String readData;
        String[] arrReadData;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((readData = br.readLine()) != null) {
                arrReadData = readData.split(",");

                if (arrReadData[0].startsWith("2021")) {
                    // 읽은 데이터 객체화
                    CsvContentDto dto = dataToObject(arrReadData);

                    if (dto != null)
                        dataList.add(dto);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    // CSV 파일 쓰기
    @Override
    public void writeDataToCsv(List<CsvContentDto> dataList, String folderName) throws IOException {
        String path = "/Users/jihunsim/Documents/dataFolder/CSV파일/" + folderName + ".csv";
        try (Writer writer = new FileWriter(path, true)) {
            StatefulBeanToCsv<Object> beanToCsv = new StatefulBeanToCsvBuilder<>(writer).build();
            beanToCsv.write(dataList);
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
    }

    // 읽은 데이터 객체화
    @Override
    public CsvContentDto dataToObject(String[] arrReadData) {
        if ((arrReadData[0] != null) && (arrReadData[19] != null) && (arrReadData[49] != null)) {
            // 시간 포맷 변경
            Timestamp timestamp = convertStringToTimestamp(arrReadData[0]);
            return CsvContentDto.builder()
                    .time(timestamp)
                    .diskioName(arrReadData[7])
                    .metricName(arrReadData[19])
                    .value(Float.valueOf(arrReadData[49]))
                    .resourceId(arrReadData[38])
                    .resourceName((arrReadData[39]))
                    .build();
        } else {
            return null;
        }
    }

    // CSV 파일 읽기
    @Override
    public void loadCsvFile(String csvFilePath) {
        File path = new File(csvFilePath);
        File[] files = path.listFiles();

        if (files != null) {
            Arrays.parallelSort(files);

            // 전체 파일 개수 만큼 반복
            for (File file : files) {

                if (file.isFile() && file.getName().endsWith("csv")) {
                    String fileName = file.getName();
                    log.info("파일명 : " + fileName);
                    String filePath = "/Users/jihunsim/Documents/dataFolder/CSV파일/" + fileName;
                    log.info("파일경로 : " + filePath);

                    // CSV 데이터 저장
                    int check = mapper.loadCsvFile(filePath);

                    if (check != 0) {
                        log.info(fileName + " 저장 성공");
                    } else {
                        log.warn(fileName + " 저장 실패");
                    }
                }
            }
        }
    }

    // 시간 파싱
    @Override
    public Timestamp convertStringToTimestamp(String time) {
        String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime localDateTime = LocalDateTime.from(formatter.parse(time));
        return Timestamp.valueOf(localDateTime);
    }

    // 출력 날짜 입력
    @Override
    public void inputTime() {
        String startYearMonthDay = "2021-10-01";
        String endYearMonthDay = "2021-10-15";
        String startHourMinuteSecond = "00:00:00";
        String endHourMinuteSecond = "00:00:00";
        String start = startYearMonthDay + "T" + startHourMinuteSecond + ".000Z";
        String end = endYearMonthDay + "T" + endHourMinuteSecond + ".000Z";

        Timestamp startTime = convertStringToTimestamp(start);
        Timestamp endTime = convertStringToTimestamp(end);

        // CSV 파일 생성
        exportFile(startTime, endTime);
    }

    // CSV 파일 생성
    @Override
    public void exportFile(Timestamp start, Timestamp end) {

        Timestamp startTime = start;

        while (end.after(startTime) || end == startTime) {
            // 1일 증가(1일 단위 파일 생성)
            Instant nextOneDay = startTime.toInstant().plusSeconds(86400);
            Timestamp plusOneDayStartTime = Timestamp.from(nextOneDay);

            String filePath = "/Users/jihunsim/Documents/dataFolder/출력데이터/" + startTime.toLocalDateTime().toLocalDate() + ".csv";

            // 데이터 추출(1일 단위 데이터)
            List<ExtractContentDto> contentList = extractDataByMinute(startTime, plusOneDayStartTime);

            try (Writer writer = new FileWriter(filePath)) {
                // 헤더 추가
                writer.append(buildHeader(ExtractContentDto.class));
                StatefulBeanToCsvBuilder<ExtractContentDto> builder = new StatefulBeanToCsvBuilder<>(writer);
                StatefulBeanToCsv<ExtractContentDto> beanToCsv = builder.build();
                beanToCsv.write(contentList);
            } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException | IOException e) {
                e.printStackTrace();
            }
            // 시작 시간 1일 증가
            log.info(filePath + ": 출력 완료");
            startTime = plusOneDayStartTime;
        }
    }

    // 데이터 추출(1일 - 1분 단위 데이터)
    @Override
    public List<ExtractContentDto> extractDataByMinute(Timestamp start, Timestamp plusOneDayStartTime) {

        Timestamp startTime = start;

        // 1일 - 1분 단위 데이터
        List<ExtractContentDto> contentList = new ArrayList<>();

        while (plusOneDayStartTime.after(startTime) || plusOneDayStartTime == startTime) {
            // 데이터 추출
            List<ExtractContentDto> extractContentList = mapper.extractDataByMinute(startTime);
            contentList.addAll(extractContentList);
            log.info(startTime + ": 데이터 추출");

            // 시작 시간 1분 증가
            Instant nextOneMinute = startTime.toInstant().plusSeconds(60);
            startTime = Timestamp.from(nextOneMinute);
        }
        return contentList;
    }

    // 헤더 생성
    @Override
    public String buildHeader(Class<ExtractContentDto> clazz) {
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(f -> f.getAnnotation(CsvBindByPosition.class) != null
                        && f.getAnnotation(CsvBindByName.class) != null)
                .sorted(Comparator.comparing(f -> f.getAnnotation(CsvBindByPosition.class).position()))
                .map(f -> f.getAnnotation(CsvBindByName.class).column())
                .collect(Collectors.joining(",")) + "\n";
    }
}
