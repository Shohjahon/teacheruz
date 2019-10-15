package com.teacher.uz.my.controllers;

import com.teacher.uz.my.domains.*;
import com.teacher.uz.my.repositories.TRoomLessonRepository;
import com.teacher.uz.my.services.*;
import com.teacher.uz.my.viewmodel.Response;
import com.teacher.uz.my.viewmodel.ScheduleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Shoh Jahon on 13.04.2018.
 */
@Controller
@RequestMapping("/json/data")
public class JsonDashboardController {
    @Autowired
    private UserService userService;
    @Autowired
    private UniversityFieldService universityFieldService;
    @Autowired
    private UniversityService universityService;
    @Autowired
    private FieldService fieldService;
    @Autowired
    private UniversityFieldUserService universityFieldUserService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private EducationHistoryService educationHistoryService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private TRoomLessonRepository tRoomLessonRepository;

    @RequestMapping("/all/users")
    @ResponseBody
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @RequestMapping("all/universities")
    @ResponseBody
    public List<University> getAllUniversities(){
        return universityService.getAllUniversities();
    }
    @RequestMapping("/all/fields")
    @ResponseBody
    public List<Field> getAllFiedls(){
        return fieldService.getAllFields();
    }
    @RequestMapping(value = "/all/university_fields", method = RequestMethod.GET)
    @ResponseBody
    public List<UniversityField> getAllUniversityFields(){
        return universityFieldService.getAllUniversityFields();
    }
    @RequestMapping(value = "/all/university_field_users")
    @ResponseBody
    public List<UniversityFieldUser> getAllUnivFUsers(){
      List<UniversityFieldUser> univFUsers = universityFieldUserService.getAllUniversityFieldUsers();
        for (int i = 0; i <univFUsers.size() ; i++) {
            User user = univFUsers.get(i).getUser();
            user.setFullName(user.getLastName()+" "+user.getFirstName());
            univFUsers.get(i).setUser(user);
        }
        return univFUsers;
    }
    @RequestMapping(value = "/all/skills")
    @ResponseBody
    public List<Skill> getAllSkills(){
        List<Skill> skills = skillService.getAllSkills();
        for (int i=0; i<skills.size(); i++) {
            User user = skills.get(i).getUser();
            user.setFullName(user.getFirstName()+" "+user.getLastName());
            skills.get(i).setUser(user);
        }
        return skills;
    }

    @RequestMapping(value = "/all/categories")
    @ResponseBody
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @RequestMapping(value = "/all/education_histories")
    @ResponseBody
    public List<EducationHistory> getAllEducationHistories(){
        List<EducationHistory> educationHistories =  educationHistoryService.getAllEducationHistories();
        for (int i = 0; i < educationHistories.size() ; i++) {
            User user = new User();
            user.setFullName(educationHistories.get(i).getUser().getLastName()+" "+educationHistories.get(i).getUser().getFirstName());
            educationHistories.get(i).setUser(user);
        }
        return educationHistories;
    }

    @RequestMapping(value = "/all/comments")
    @ResponseBody
    public List<Comment> getAllComments(){
        List<Comment> comments = commentService.getAllComments();
        for (int i = 0; i < comments.size(); i++) {
            User user = comments.get(i).getUser();
            user.setFullName(user.getLastName()+" "+user.getFirstName());
            comments.get(i).setUser(user);
        }
        return comments;
    }

    @RequestMapping(value = "/all/articles")
    @ResponseBody
    public List<Article> getAllArticles(){
        List<Article> articles = articleService.getAllArticles();
        for (int i = 0; i < articles.size(); i++) {
            User user = articles.get(i).getUser();
            user.setFullName(user.getId() + "." + user.getLastName() + " " + user.getFirstName());
            articles.get(i).setUser(user);
        }
        return articles;
    }
    @RequestMapping(value = "/all/subjects")
    @ResponseBody
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjecs();
    }

    @RequestMapping("/all/teacher_rooms")
    @ResponseBody
    public List<TRoomLesson> getTRoomLessons(){
        List<TRoomLesson> tRoomLessons = tRoomLessonRepository.findAll();
        for (int i = 0; i < tRoomLessons.size(); i++) {
            User user = tRoomLessons.get(i).getUser();
            user.setFullName(user.getId()+"."+user.getLastName()+" "+user.getFirstName());
            tRoomLessons.get(i).setUser(user);
        }
        return tRoomLessons;
    }

    @RequestMapping("/all/teacher/{id}/room")
    @ResponseBody
    public List<TRoomLesson> getTRoomLessonByTeacher(@PathVariable("id") int id){
       List<TRoomLesson> tRoomLessons = tRoomLessonRepository.findTRoomLessonsByUserId(Long.valueOf(id));
        for (int i = 0; i < tRoomLessons.size(); i++) {
            User user = tRoomLessons.get(i).getUser();
            user.setFullName(user.getId()+"."+user.getLastName()+" "+user.getFirstName());
            tRoomLessons.get(i).setUser(user);
        }
        return tRoomLessons;
    }


}
