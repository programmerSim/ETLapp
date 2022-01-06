package com.data.etldata;

import com.data.etldata.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class EtldataAppRunner implements ApplicationRunner {

    DataService dataService;

    @Autowired
    private EtldataAppRunner(DataService dataService) {
        this.dataService = dataService;
    }

    @Override
    public void run(ApplicationArguments args) {
        dataService.action();
    }
}
