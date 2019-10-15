package com.teacher.uz.my.services;

import com.teacher.uz.my.domains.Subject;
import com.teacher.uz.my.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shoh Jahon on 04.05.2018.
 */
@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjecs(){
        return subjectRepository.findAll();
    }
    public Subject getSubject(int id){
        return subjectRepository.findOne(Long.valueOf(id));
    }
    public void saveSubject(Subject subject){
        subjectRepository.save(subject);
    }
    public void deleteSubject(int id){
        subjectRepository.delete(Long.valueOf(id));
    }
}
