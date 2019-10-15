package com.teacher.uz.my.services;

import com.teacher.uz.my.domains.Test;
import com.teacher.uz.my.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shoh Jahon on 04.05.2018.
 */
@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    public List<Test> getAllTests(){
        return testRepository.findAll();
    }
    public Test getTest(int id){
        return testRepository.findOne(Long.valueOf(id));
    }
    public void saveTest(Test test){
        testRepository.save(test);
    }
    public void deleteTest(int id){
        testRepository.delete(Long.valueOf(id));
    }
}
