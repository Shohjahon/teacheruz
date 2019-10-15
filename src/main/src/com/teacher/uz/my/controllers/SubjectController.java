package com.teacher.uz.my.controllers;

import com.teacher.uz.my.domains.Category;
import com.teacher.uz.my.domains.Subject;
import com.teacher.uz.my.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Shoh Jahon on 10.05.2018.
 */
@Controller
@RequestMapping("subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/subjects", method = RequestMethod.GET)
    public ModelAndView showManageSubjects(){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickSubjectList",true);
        mv.addObject("title", "Subject");
        return mv;
    }

    @RequestMapping(value = "/create/subject",method = RequestMethod.GET)
    public ModelAndView showCreateSubject(){
        ModelAndView mv = new ModelAndView("dashboard");
        Subject subject = new Subject();
        mv.addObject("title","Subject");
        mv.addObject("subject",subject);
        mv.addObject("userClickCreateSubject",true);
        return mv;
    }

    @RequestMapping(value = "/create/{id}/subject",method = RequestMethod.GET)
    public ModelAndView showUpdateSubject(@PathVariable int id){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickCreateSubject",true);
        mv.addObject("title","Update Subject");
        Subject subject = subjectService.getSubject(id);
        mv.addObject("subject",subject);
        return mv;
    }
    @RequestMapping(value = "/create/subject", method = RequestMethod.POST)
    public String showCreateSubject(@ModelAttribute("subject") Subject subject){
        subjectService.saveSubject(subject);
        return "redirect:/subject/subjects";
    }

    @RequestMapping(value = "/delete/{id}/subject", method = RequestMethod.POST)
    @ResponseBody
    public String handleSubjectDeletion(@PathVariable int id){
        subjectService.deleteSubject(id);
        return "You have successfully removed this subject!";
    }
}
