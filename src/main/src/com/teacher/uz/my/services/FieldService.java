package com.teacher.uz.my.services;

import com.teacher.uz.my.domains.Field;
import com.teacher.uz.my.domains.University;
import com.teacher.uz.my.repositories.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shoh Jahon on 13.04.2018.
 */
@Service
public class FieldService {
    @Autowired
    private FieldRepository fieldRepository;

    public List<Field> getAllFields(){
        return fieldRepository.findAll();
    }
    public Field getField(Long id){
        return fieldRepository.findOne(id);
    }
    public void saveField(Field field){
        fieldRepository.save(field);
    }
    public void deleteField(Long id){
        fieldRepository.delete(getField(id));
    }
}
