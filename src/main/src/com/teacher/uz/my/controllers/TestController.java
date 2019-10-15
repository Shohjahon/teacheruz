package com.teacher.uz.my.controllers;

import com.teacher.uz.my.domains.Category;
import com.teacher.uz.my.domains.Subject;
import com.teacher.uz.my.domains.Test;
import com.teacher.uz.my.domains.User;
import com.teacher.uz.my.services.SubjectService;
import com.teacher.uz.my.services.TestService;
import com.teacher.uz.my.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.enterprise.inject.Model;
import java.util.List;

/**
 * Created by Shoh Jahon on 10.05.2018.
 */
@Controller
@RequestMapping("test")
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private UserService userService;
    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/tests", method = RequestMethod.GET)
    public ModelAndView showManageTests(){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickTestList",true);
        mv.addObject("title", "Test");
        return mv;
    }

    @RequestMapping(value = "/create/test",method = RequestMethod.GET)
    public ModelAndView showCreateTest(){
        ModelAndView mv = new ModelAndView("dashboard");
        Test test = new Test();
        mv.addObject("title","Test");
        mv.addObject("test",test);
        mv.addObject("userClickCreateTest",true);
        return mv;
    }

    @RequestMapping(value = "/create/{id}/test",method = RequestMethod.GET)
    public ModelAndView showUpdateTest(@PathVariable int id){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickCreateTest",true);
        mv.addObject("title","Update Test");
        Test test = testService.getTest(id);
        mv.addObject("test",test);
        return mv;
    }
    @RequestMapping(value = "/create/test", method = RequestMethod.POST)
    public String showCreateTest(@ModelAttribute("test") Test test){
        testService.saveTest(test);
        return "redirect:/test/tests";
    }

    @RequestMapping(value = "/delete/{id}/test", method = RequestMethod.POST)
    @ResponseBody
    public String handleTestDeletion(@PathVariable int id){
        testService.deleteTest(id);
        return "You have successfully removed this test!";
    }

    @ModelAttribute("subjects")
    public List<Subject> getSubjects(){
        return subjectService.getAllSubjecs();
    }
    @ModelAttribute("subject")
    public Subject getSubject(){
        return new Subject();
    }

    @ModelAttribute("users")
    public List<User> getUsers(){
        List<User> users = userService.getAllUsers();
        for (int i = 0; i <users.size() ; i++) {
            users.get(i).setFullName(users.get(i).getId()+"-"+users.get(i).getLastName()+" "+users.get(i).getFirstName());
        }
        return users;
    }
    @ModelAttribute("user")
    public User getUser(){
        return new User();
    }
}
