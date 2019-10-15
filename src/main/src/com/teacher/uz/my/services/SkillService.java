package com.teacher.uz.my.services;

import com.teacher.uz.my.domains.Category;
import com.teacher.uz.my.domains.Skill;
import com.teacher.uz.my.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shoh Jahon on 04.05.2018.
 */
@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> getAllSkills(){
        return skillRepository.findAll();
    }
    public List<Skill> getSkillsByCategory(Category category){
        return skillRepository.findSkillsByCategoryId(category.getId());
    }
    public Skill getSkill(int id){
        return skillRepository.findOne(Long.valueOf(id));
    }
    public void savaSkill(Skill skill){
        skillRepository.save(skill);
    }
    public void deleteSkill(int id){
        skillRepository.delete(Long.valueOf(id));
    }
    public List<Skill> getSkillByUser(Long id){
        return skillRepository.findSkillsByUserId(id);
    }
}
