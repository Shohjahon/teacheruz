package com.teacher.uz.my.controllers;

import com.teacher.uz.my.domains.*;
import com.teacher.uz.my.services.CategoryService;
import com.teacher.uz.my.services.SkillService;
import com.teacher.uz.my.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Shoh Jahon on 05.05.2018.
 */
@Controller
@RequestMapping("skill")
public class SkillController {
    @Autowired
    private SkillService skillService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/skills", method = RequestMethod.GET)
    public ModelAndView showManageSkill(){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickSkillList",true);
        mv.addObject("title", "Skill");
        return mv;
    }

    @RequestMapping(value = "/create/skill",method = RequestMethod.GET)
    public ModelAndView showCreateSkill(){
        ModelAndView mv = new ModelAndView("dashboard");
        Skill skill = new Skill();
        mv.addObject("title","Skill");
        mv.addObject("skill",skill);
        mv.addObject("userClickCreateSkill",true);
        return mv;
    }

    @RequestMapping(value = "/create/{id}/skill",method = RequestMethod.GET)
    public ModelAndView showUpdateSkill(@PathVariable int id){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickCreateSkill",true);
        mv.addObject("title","Update Skill");
        Skill skill = skillService.getSkill(id);
        mv.addObject("skill",skill);
        return mv;
    }
    @RequestMapping(value = "/create/skill", method = RequestMethod.POST)
    public String showCreateSkill(@ModelAttribute("skill") Skill skill){
        skillService.savaSkill(skill);
        return "redirect:/skill/skills";
    }

    @RequestMapping(value = "/delete/{id}/skill", method = RequestMethod.POST)
    @ResponseBody
    public String handleSkillDeletion(@PathVariable int id){
        Skill skill = skillService.getSkill(id);
        boolean isActive = skill.isActive();
        skill.setActive(!isActive);
        skillService.savaSkill(skill);
        return isActive?"You have successfully deactivated skill with id " + skill.getId():
                "You have successfully activated skill with id "+skill.getId();
    }

    @ModelAttribute("categories")
    public List<Category> getCategories(){
        return categoryService.getAllCategories();
    }
    @ModelAttribute("category")
    public Category getCategory(){
        return new Category();
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
