package com.teacher.uz.my.controllers;

import com.teacher.uz.my.domains.*;
import com.teacher.uz.my.repositories.TRoomLessonRepository;
import com.teacher.uz.my.services.*;
import com.teacher.uz.my.utilities.FileUploadUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Shoh Jahon on 13.05.2018.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private UniversityFieldUserService universityFieldUserService;
    @Autowired
    private EducationHistoryService educationHistoryService;
    @Autowired
    private TRoomLessonRepository tRoomLessonRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam(name = "error",required = false)String error,
                              @RequestParam(name = "logout",required = false)String logout){
        ModelAndView mv = new ModelAndView("login");

        if (error!=null){
            mv.addObject("message","Invalid Username and Password!");
        }

        if (logout!=null){
            mv.addObject("logout","User Successfully logged out!");
        }

        mv.addObject("title","Login");
        return mv;
    }

    @RequestMapping(value = "/perform-logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){

        //Dastlab autentifikatsiyadan o'tgan user borligiga tekshiramiz
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication!=null){
            new SecurityContextLogoutHandler().logout(request,response,authentication);
        }
        return "redirect:/login?logout";
    }

    @RequestMapping(value = "/access-denied")
    public ModelAndView accessDenied(){
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("title","403 - Access Denied");
        mv.addObject("errorTitle","Aha! Caught You.");
        mv.addObject("errorDescription","You are not authorized to view this page!");
        return mv;
    }

    @RequestMapping(value = "/personal/{id}/profile",method = RequestMethod.GET)
    public ModelAndView getPersonalProfile(@PathVariable Integer id){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("userClickPersonal",true);
        List<Skill> skillList = skillService.getSkillByUser(Long.valueOf(id));
        UniversityFieldUser universityFieldUser = universityFieldUserService.getUniversityFieldUserById(id);
        mv.addObject("universityFieldUser",universityFieldUser);
        EducationHistory educationHistory = educationHistoryService.getEducationHistoryByUser(id);
        mv.addObject("educationHistory",educationHistory);
        List<TRoomLesson> tRoomLessons = tRoomLessonRepository.findTRoomLessonsByUserId(Long.valueOf(id));
        mv.addObject("schedule",tRoomLessons);
        mv.addObject("skills",skillList);

        //Edit profile enities
        User user = userService.getUser(Long.valueOf(id));
        mv.addObject("user",user);
        //Edit profile enities
        //Article entity
        Article article = new Article();
        article.setUser(user);
        mv.addObject("article",article);
        //Article entity
        return mv;
    }

    @RequestMapping(value = "/personal/edit/user",method = RequestMethod.POST)
    public String handleUserUpdate(@ModelAttribute("user") User user,
                                   Model model,
                                   HttpServletRequest request){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);

        if (!user.getThumbnail().getOriginalFilename().equals("")){
            FileUploadUtility.uploadFile(request,user.getThumbnail(),user.getCode());
        }
        return "redirect:/personal/"+user.getId()+"/profile";
    }

    @RequestMapping(value = "/personal/create/article", method = RequestMethod.POST)
    public String handleArticleSubmission(@ModelAttribute("article") Article article,
                                          Model model,
                                          HttpServletRequest request) throws IOException {
        articleService.saveArticel(article);

        if (!article.getVideoContent().getOriginalFilename().isEmpty()) {
            BufferedOutputStream outputStream = new BufferedOutputStream(
                    new FileOutputStream(
                            new File("D:\\Intellij\\Teacher.uz\\MyTeacher.Uz\\src\\main\\webapp\\resources\\videos\\", article.getVideoUrl())+".mp4"));
            outputStream.write(article.getVideoContent().getBytes());
            outputStream.flush();
            outputStream.close();
        }
        return "redirect:/courses";

    }

    @ModelAttribute("subjects")
    public List<Subject> getSubjects(){
        return subjectService.getAllSubjecs();
    }
    @ModelAttribute("subject")
    public Subject getSubject(){
        return new Subject();
    }
}
