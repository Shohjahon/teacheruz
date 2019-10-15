package com.teacher.uz.my.controllers;

import com.teacher.uz.my.domains.Field;
import com.teacher.uz.my.domains.University;
import com.teacher.uz.my.domains.UniversityFieldUser;
import com.teacher.uz.my.domains.User;
import com.teacher.uz.my.services.FieldService;
import com.teacher.uz.my.services.UniversityFieldUserService;
import com.teacher.uz.my.services.UniversityService;
import com.teacher.uz.my.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.enterprise.inject.Model;
import java.util.List;

/**
 * Created by Shoh Jahon on 23.04.2018.
 */
@Controller
@RequestMapping("university_field_user")
public class UniversityFieldUserController {
    @Autowired
    private UniversityFieldUserService universityFieldUserService;
    @Autowired
    private UniversityService universityService;
    @Autowired
    private FieldService fieldService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/university_field_users",method = RequestMethod.GET)
    public ModelAndView showManageUniversityFieldUser(){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickUniversityFieldUserList",true);
        mv.addObject("title","University & Field & User");
        return mv;
    }
    @RequestMapping(value = "/create/university_field_user", method = RequestMethod.GET)
    public ModelAndView showCreateUniversityFieldUser(){
        ModelAndView mv = new ModelAndView("dashboard");
        UniversityFieldUser universityFieldUser = new UniversityFieldUser();
        mv.addObject("title","University & Field & User");
        mv.addObject("universityFieldUser",universityFieldUser);
        mv.addObject("userClickCreateUniversityFieldUser",true);
        return mv;
    }
    @RequestMapping(value = "/create/{id}/university_field_user",method = RequestMethod.GET)
    public ModelAndView showUpdateUniversityFieldUser(@PathVariable int id){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickCreateUniversityFieldUser",true);
        mv.addObject("title","Update University Field User");
        UniversityFieldUser universityFieldUser = universityFieldUserService.getUniversityFieldUser(Long.valueOf(id));
        mv.addObject("universityFieldUser",universityFieldUser);
        return mv;
    }
    @RequestMapping(value = "/create/university_field_user", method = RequestMethod.POST)
    public String showCreateUniversityFieldUser(@ModelAttribute("universityFieldUser") UniversityFieldUser universityFieldUser){
        universityFieldUserService.saveUniversityFieldUser(universityFieldUser);
        return "redirect:/university_field_user/university_field_users";
    }

    @RequestMapping(value = "/delete/{id}/university_field_user", method = RequestMethod.POST)
    @ResponseBody
    public String handleUniversiytFieldUserDeletion(@PathVariable int id){
        UniversityFieldUser universityFieldUser = universityFieldUserService.getUniversityFieldUser(Long.valueOf(id));
        boolean isActive = universityFieldUser.isActive();
        universityFieldUser.setActive(!isActive);
        universityFieldUserService.saveUniversityFieldUser(universityFieldUser);
        return isActive?"You have successfully deactivated university field user with id " + universityFieldUser.getId():
                "You have successfully activated university field user with id "+universityFieldUser.getId();
    }

    @ModelAttribute("universities")
    public List<University> getUniversities(){
        return universityService.getAllUniversities();
    }
    @ModelAttribute("university")
    public University getUniversity(){
        return new University();
    }
    @ModelAttribute("fields")
    public List<Field> getFields(){
        return fieldService.getAllFields();
    }
    @ModelAttribute("field")
    public Field getField(){
        return new Field();
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
