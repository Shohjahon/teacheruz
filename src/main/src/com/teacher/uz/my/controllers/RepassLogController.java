package com.teacher.uz.my.controllers;

import com.teacher.uz.my.domains.Comment;
import com.teacher.uz.my.domains.RepassLog;
import com.teacher.uz.my.services.RepassLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Shoh Jahon on 10.05.2018.
 */
@Controller
@RequestMapping("repass_log")
public class RepassLogController {
    @Autowired
    private RepassLogService repassLogService;

    @RequestMapping(value = "/repass_logs", method = RequestMethod.GET)
    public ModelAndView showManageRepassLogs(){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickRepassLogList",true);
        mv.addObject("title", "Repass Log");
        return mv;
    }

    @RequestMapping(value = "/create/repass_log",method = RequestMethod.GET)
    public ModelAndView showCreateRepassLog(){
        ModelAndView mv = new ModelAndView("dashboard");
        RepassLog repassLog = new RepassLog();
        mv.addObject("title","Repass Log");
        mv.addObject("repassLog",repassLog);
        mv.addObject("userClickCreateRepassLog",true);
        return mv;
    }

    @RequestMapping(value = "/create/{id}/repass_log",method = RequestMethod.GET)
    public ModelAndView showUpdateRepassLog(@PathVariable int id){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickCreateRepassLog",true);
        mv.addObject("title","Update Repass Log");
        RepassLog repassLog = repassLogService.getRepassLog(id);
        mv.addObject("repassLog",repassLog);
        return mv;
    }
    @RequestMapping(value = "/create/repass_log", method = RequestMethod.POST)
    public String showCreateRepassLog(@ModelAttribute("repassLog") RepassLog repassLog){
        repassLogService.saveRepassLog(repassLog);
        return "redirect:/repass_log/repass_logs";
    }

    @RequestMapping(value = "/delete/{id}/repass_log", method = RequestMethod.POST)
    @ResponseBody
    public String handleCommentRepassLog(@PathVariable int id){
        repassLogService.deleteRepassLog(id);
        return "You have successfully removed this repass log!";
    }
}
