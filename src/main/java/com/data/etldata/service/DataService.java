package com.data.etldata.service;

import com.data.etldata.dto.CsvContentDto;
import com.data.etldata.dto.ExtractContentDto;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

public interface DataService {

    // 실행
    void action();

    // 파일 선택
    void selectFileToCsv(String dirPath, String name);

    // 파일 읽기
    List<CsvContentDto> readFileToCsv(File file);

    // CSV 파일 쓰기
    void writeDataToCsv(List<CsvContentDto> dataList, String folderName) throws IOException;

    // 데이터 객체화
    CsvContentDto dataToObject(String[] arrReadData);

    // CSV 파일 읽기
    void loadCsvFile(String csvFilePath);

    // 출력 날짜 입력
    void inputTime();

    // 시간 파싱
    Timestamp convertStringToTimestamp(String time);

    // CSV 파일 생성
    void exportFile(Timestamp startTime, Timestamp endTime);

    // 데이터 추출(1일 1분 단위 데이터)
    List<ExtractContentDto> extractDataByMinute(Timestamp startTime, Timestamp endTime);

    // 헤더 생성
    public String buildHeader(Class<ExtractContentDto> clazz);
}
