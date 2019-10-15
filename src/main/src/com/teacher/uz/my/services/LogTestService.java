package com.teacher.uz.my.services;

import com.teacher.uz.my.domains.LogTest;
import com.teacher.uz.my.repositories.LogTestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shoh Jahon on 04.05.2018.
 */
@Service
public class LogTestService {
    private LogTestRepository logTestRepository;

    public List<LogTest> getAllLogTest(){
        return logTestRepository.findAll();
    }
    public LogTest getLogTest(int id){
        return logTestRepository.findOne(Long.valueOf(id));
    }
    public void saveLogTest(LogTest logTest){
        logTestRepository.save(logTest);
    }
    public void deleteLogTest(int id){
        logTestRepository.delete(Long.valueOf(id));
    }
}
