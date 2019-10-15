package com.teacher.uz.my.services;

import com.teacher.uz.my.domains.University;
import com.teacher.uz.my.repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shoh Jahon on 13.04.2018.
 */
@Service
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;

    public List<University> getAllUniversities(){
       return universityRepository.findAll();
    }
    public University getUniversity(Long id){
       return universityRepository.findOne(id);
    }
    public void saveUniversity(University university){
        universityRepository.save(university);
    }
    public void deleteUniversity(Long id){
        universityRepository.delete(universityRepository.findOne(id));
    }
}
