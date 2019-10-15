package com.teacher.uz.my.services;

import com.teacher.uz.my.domains.EducationHistory;
import com.teacher.uz.my.repositories.EducationHistoryRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shoh Jahon on 04.05.2018.
 */
@Service
public class EducationHistoryService {
    @Autowired
    private EducationHistoryRepository educationHistoryRepository;

    public List<EducationHistory> getAllEducationHistories(){
        return  educationHistoryRepository.findAll();
    }
    public EducationHistory getEducationHistory(int id){
        return educationHistoryRepository.findOne(Long.valueOf(id));
    }
    public void saveEducationHistory(EducationHistory educationHistory){
        educationHistoryRepository.save(educationHistory);
    }
    public void deleteEducationHistory(int id){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            EducationHistory educationHistory = (EducationHistory) session.get(EducationHistory.class,Long.valueOf(id));
            session.delete(educationHistory);
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public EducationHistory getEducationHistoryByUser(int id){
        return educationHistoryRepository.findEducationHistoryByUserId(Long.valueOf(id));
    }
}
