package com.teacher.uz.my.services;

import com.teacher.uz.my.domains.RepassLog;
import com.teacher.uz.my.repositories.RepassLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shoh Jahon on 04.05.2018.
 */
@Service
public class RepassLogService {
    @Autowired
    private RepassLogRepository repassLogRepository;

    public List<RepassLog> getAllRepassLogs(){
        return repassLogRepository.findAll();
    }
    public RepassLog getRepassLog(int id){
        return repassLogRepository.findOne(Long.valueOf(id));
    }
    public void saveRepassLog(RepassLog repassLog){
        repassLogRepository.save(repassLog);
    }
    public void deleteRepassLog(int id){
        repassLogRepository.delete(Long.valueOf(id));
    }
}
