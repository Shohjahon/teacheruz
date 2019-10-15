package com.teacher.uz.my.controllers;

import com.teacher.uz.my.domains.Category;
import com.teacher.uz.my.domains.EducationHistory;
import com.teacher.uz.my.domains.User;
import com.teacher.uz.my.services.EducationHistoryService;
import com.teacher.uz.my.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Shoh Jahon on 10.05.2018.
 */
@Controller
@RequestMapping("education_history")
public class EducationHistoryController {
    @Autowired
    private EducationHistoryService educationHistoryService;
    @Autowired
    private UserService userService;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }


    @RequestMapping(value = "/education_histories", method = RequestMethod.GET)
    public ModelAndView showManageEducationHistory(){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickEducationHistoryList",true);
        mv.addObject("title", "Education History");
        return mv;
    }

    @RequestMapping(value = "/create/education_history",method = RequestMethod.GET)
    public ModelAndView showCreateEducationHistory(){
        ModelAndView mv = new ModelAndView("dashboard");
        EducationHistory educationHistory = new EducationHistory();
        mv.addObject("title","Education History");
        mv.addObject("educationHistory",educationHistory);
        mv.addObject("userClickCreateEducationHistory",true);
        return mv;
    }

    @RequestMapping(value = "/create/{id}/education_history",method = RequestMethod.GET)
    public ModelAndView showUpdateEducationHistory(@PathVariable int id){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickCreateEducationHistory",true);
        mv.addObject("title","Update EducationHistory");
        EducationHistory educationHistory = educationHistoryService.getEducationHistory(id);
        mv.addObject("educationHistory",educationHistory);
        return mv;
    }
    @RequestMapping(value = "/create/education_history", method = RequestMethod.POST)
    public String showCreateEducationHistory(@ModelAttribute("educationHistory") EducationHistory educationHistory){
        educationHistoryService.saveEducationHistory(educationHistory);
        return "redirect:/education_history/education_histories";
    }

    @RequestMapping(value = "/delete/{id}/education_history", method = RequestMethod.POST)
    @ResponseBody
    public String handleEducationHistoryDeletion(@PathVariable int id){
        educationHistoryService.deleteEducationHistory(id);
        return "You have successfully removed this education history!";
    }

    @ModelAttribute("users")
    public List<User> getUsers(){
        List<User> users = userService.getAllUsers();
        for (int i = 0; i <users.size() ; i++) {
            users.get(i).setFullName(users.get(i).getId()+"."+users.get(i).getLastName()+" "+users.get(i).getFirstName());
        }
        return users;
    }
    @ModelAttribute("user")
    public User getUser(){
        return new User();
    }
}
