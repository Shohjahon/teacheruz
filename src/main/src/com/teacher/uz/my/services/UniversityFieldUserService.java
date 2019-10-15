package com.teacher.uz.my.services;

import com.teacher.uz.my.domains.UniversityFieldUser;
import com.teacher.uz.my.repositories.UniversityFieldUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Shoh Jahon on 20.04.2018.
 */
@Service
@Transactional
public class UniversityFieldUserService {
    @Autowired
    private UniversityFieldUserRepository universityFieldUserRepository;
    public List<UniversityFieldUser> getAllUniversityFieldUsers(){
        return universityFieldUserRepository.findAll();
    }
    public UniversityFieldUser getUniversityFieldUser(Long id){
        return universityFieldUserRepository.findOne(id);
    }
    public void saveUniversityFieldUser(UniversityFieldUser univFUsers){
        universityFieldUserRepository.save(univFUsers);
    }
    public void deleteUniversityFieldUser(Long id){
     universityFieldUserRepository.delete(id);
    }
    public UniversityFieldUser getUniversityFieldUserById(int id){
        return universityFieldUserRepository.findUniversityFieldUserByUserId(Long.valueOf(id));
    }
}
