package com.teacher.uz.my.controllers;

import com.teacher.uz.my.domains.Category;
import com.teacher.uz.my.domains.LogTest;
import com.teacher.uz.my.domains.RepassLog;
import com.teacher.uz.my.domains.Test;
import com.teacher.uz.my.services.LogTestService;
import com.teacher.uz.my.services.RepassLogService;
import com.teacher.uz.my.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.enterprise.inject.Model;
import java.util.List;

/**
 * Created by Shoh Jahon on 10.05.2018.
 */
@Controller
@RequestMapping("log_test")
public class LogTestController {
    @Autowired
    private RepassLogService repassLogService;
    @Autowired
    private TestService testService;
    @Autowired
    private LogTestService logTestService;

    @RequestMapping(value = "/log_tests", method = RequestMethod.GET)
    public ModelAndView showManageLogTest(){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickLogTestList",true);
        mv.addObject("title", "Log Test");
        return mv;
    }

    @RequestMapping(value = "/create/log_test",method = RequestMethod.GET)
    public ModelAndView showCreateLogTest(){
        ModelAndView mv = new ModelAndView("dashboard");
        LogTest logTest = new LogTest();
        mv.addObject("title","Log Test");
        mv.addObject("logTest",logTest);
        mv.addObject("userClickCreateLogTest",true);
        return mv;
    }

    @RequestMapping(value = "/create/{id}/log_test",method = RequestMethod.GET)
    public ModelAndView showUpdateLogTest(@PathVariable int id){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickCreateLogTest",true);
        mv.addObject("title","Update Log Test");
        LogTest logTest = logTestService.getLogTest(id);
        mv.addObject("logTest",logTest);
        return mv;
    }
    @RequestMapping(value = "/create/log_test", method = RequestMethod.POST)
    public String showCreateLogTest(@ModelAttribute("logTest") LogTest logTest){
        logTestService.saveLogTest(logTest);
        return "redirect:/log_test/log_tests";
    }

    @ModelAttribute("tests")
    public List<Test> getTests(){
        return testService.getAllTests();
    }
    @ModelAttribute("test")
    public Test getTest(){
        return new Test();
    }
    @ModelAttribute("repassLogs")
    public List<RepassLog> getRepassLogs(){
        return repassLogService.getAllRepassLogs();
    }
    @ModelAttribute("repassLog")
    public RepassLog getRepassLog(){
        return new RepassLog();
    }
}
