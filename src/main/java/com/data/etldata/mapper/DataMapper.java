package com.data.etldata.mapper;

import com.data.etldata.dto.ExtractContentDto;

import java.sql.Timestamp;
import java.util.List;

public interface DataMapper {

    // CSV 데이터 저장
    public int loadCsvFile(String filePath);

    // 데이터 추출
    public List<ExtractContentDto> extractDataByMinute(Timestamp time);
}
