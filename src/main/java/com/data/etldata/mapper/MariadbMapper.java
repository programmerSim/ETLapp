package com.data.etldata.mapper;

import com.data.etldata.dto.ExtractContentDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.List;

@Slf4j
public class MariadbMapper implements DataMapper {

    @Autowired
    private SqlSession sqlSession;

    private String statement = "com.data.etldata.mapper.DataMapper";

    // CSV 파일 데이터 저장
    @Override
    public int loadCsvFile(String filePath) {
        return sqlSession.insert(statement + ".loadCsvFile", filePath);
    }

    // 데이터 추출
    @Override
    public List<ExtractContentDto> extractDataByMinute(Timestamp time) {
        return sqlSession.selectList(statement + ".extractDataByMinute", time);
    }
}
