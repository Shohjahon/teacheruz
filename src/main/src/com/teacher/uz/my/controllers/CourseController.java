package com.teacher.uz.my.controllers;

import com.teacher.uz.my.domains.Article;
import com.teacher.uz.my.services.ArticleService;
import com.teacher.uz.my.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Shoh Jahon on 14.05.2018.
 */
@Controller
public class CourseController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/show/subject/{id}/articles")
    public ModelAndView showSubjectArticles(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("userClickCourses", true);
        mv.addObject("articles",articleService.getArticlesBySubjects(id));
        mv.addObject("subjects",subjectService.getAllSubjecs());
        mv.addObject("title","Courses");
        return mv;
    }

    @RequestMapping(value = "/courses/{id}/course", method = RequestMethod.POST)
    @ResponseBody
    public String likeCourse(@PathVariable("id") int id){
        Article article = articleService.getArticle(id);
        int point = article.getUserPoint();
        point = point + 1;
        article.setUserPoint(point);
        articleService.saveArticel(article);
        return String.valueOf(point);
    }
}
