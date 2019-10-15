package com.teacher.uz.my.services;

import com.teacher.uz.my.domains.Article;
import com.teacher.uz.my.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shoh Jahon on 04.05.2018.
 */
@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

   public List<Article> getAllArticles(){
       return articleRepository.findAll();
   }
   public Article getArticle(int id){
       return articleRepository.findOne(Long.valueOf(id));
   }
   public void saveArticel(Article object){
       articleRepository.save(object);
   }
   public void deleteArticle(int id){
       System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>:"+id);
       articleRepository.delete(Long.valueOf(id));
   }
   public List<Article> getArticlesBySubjects(int id){
       return articleRepository.findArticleBySubjectId(Long.valueOf(id));
   }
}
