package com.data.etldata.config;

import com.data.etldata.mapper.DataMapper;
import com.data.etldata.mapper.MariadbMapper;
import com.data.etldata.service.CsvService;
import com.data.etldata.service.DataService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public DataService dataService() {
        return new CsvService(dataMapper());
    }

    @Bean
    public DataMapper dataMapper() {
        return new MariadbMapper();
    }
}
