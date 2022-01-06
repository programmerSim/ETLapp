package com.data.etldata.dto;

import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Builder
@Getter
@AllArgsConstructor
public class CsvContentDto {
    @CsvBindByPosition(position = 0)
    private final Timestamp time; // 시간 0번째

    @CsvBindByPosition(position = 1)
    private final String diskioName; // diskio명 7번째

    @CsvBindByPosition(position = 2)
    private final String metricName; // metric명 19번째

    @CsvBindByPosition(position = 3)
    private final Float value; // metric값 49번째

    @CsvBindByPosition(position = 4)
    private final String resourceId; // 장비ID 38번째

    @CsvBindByPosition(position = 5)
    private final String resourceName; // 장비명 39번째
}
