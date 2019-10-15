package com.teacher.uz.my.services;

import com.teacher.uz.my.domains.UniversityField;
import com.teacher.uz.my.repositories.UniversityFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shoh Jahon on 13.04.2018.
 */
@Service
public class UniversityFieldService {
    @Autowired
    private UniversityFieldRepository universityFieldRepository;

    public List<UniversityField> getAllUniversityFields(){
        return universityFieldRepository.findAll();
    }
    public UniversityField getUniversityField(int id){
        return universityFieldRepository.findOne((long) id);
    }
    public void deleteUniversityField(int id){
        universityFieldRepository.delete(Long.valueOf(id));
    }
    public void saveUniversityField(UniversityField universityField){
        universityFieldRepository.save(universityField);
    }
}
