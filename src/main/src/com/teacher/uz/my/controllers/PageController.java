package com.teacher.uz.my.controllers;

import com.teacher.uz.my.domains.*;
import com.teacher.uz.my.repositories.GroupRepository;
import com.teacher.uz.my.repositories.LessonRepository;
import com.teacher.uz.my.repositories.RoomRepository;
import com.teacher.uz.my.repositories.TRoomLessonRepository;
import com.teacher.uz.my.services.ArticleService;
import com.teacher.uz.my.services.SubjectService;
import com.teacher.uz.my.services.UserService;
import com.teacher.uz.my.viewmodel.SubmitSemesterModel;
import com.teacher.uz.my.viewmodel.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shoh Jahon on 10.04.2018.
 */
@Controller
public class PageController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private TRoomLessonRepository tRoomLessonRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private HttpSession session;
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/","/home","/index"})
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title","Home");
        mv.addObject("userClickHome",true);
        return mv;
    }



    @RequestMapping({"/dashboard","/mydashboard/users"})
    public ModelAndView dashboard(){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickUserList",true);
        List<User> users = new ArrayList<>();
        mv.addObject("users",users);
        mv.addObject("title","Dashboard - User Management");
        return mv;
    }

    @RequestMapping("/courses")
    public ModelAndView courses(){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("userClickCourses", true);
        List<Article> articles = articleService.getAllArticles();
        for (int i = 0; i < articles.size(); i++) {
            User user = articles.get(i).getUser();
            user.setFullName(user.getLastName() + " " + user.getFirstName());
            articles.get(i).setUser(user);
        }
        mv.addObject("articles",articles);
        mv.addObject("subjects",subjectService.getAllSubjecs());
        mv.addObject("title","Courses");
        return mv;
    }

    @RequestMapping("/about_us")
    public ModelAndView about(){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("userClickAboutUs", true);
        mv.addObject("title","About Us");
        return mv;
    }

    @RequestMapping(value = "/manage_groups", method = RequestMethod.GET)
    public ModelAndView manageGroups(@RequestParam(name = "operation",required = false) String operation){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("userClickManageGroups", true);
        mv.addObject("title","Manage Groups");
        TRoomLesson tRoomLesson = new TRoomLesson();
        mv.addObject("tRoomLesson",tRoomLesson);
        UserModel userModel = (UserModel) session.getAttribute("userModel");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>...." + userModel.getFull_name());

        if (operation!=null){
            if (operation.equals("accepted")){
                mv.addObject("message","You have successfully submitted this plan!");
            }else if (operation.equals("fail")){
                mv.addObject("messagefail","The room you have chosen is not vacant now! Please choose other rooms or day!");
            }
        }
        return mv;
    }

    @RequestMapping(value = "/create/manage_groups",method = RequestMethod.POST)
    public String planSubmission(@ModelAttribute("tRoomLesson") TRoomLesson tRoomLesson,
                                 BindingResult result, Model model){
        List<TRoomLesson> tRoomLessons = tRoomLessonRepository.findAll();
        UserModel userModel = (UserModel) session.getAttribute("userModel");
        User user = userService.getUser(userModel.getId());
        tRoomLesson.setUser(user);
        for (int i = 0; i < tRoomLessons.size(); i++) {
            if (tRoomLesson.getPair().equals(tRoomLessons.get(i).getPair())&&
                    tRoomLesson.getDayOfWeek().equals(tRoomLessons.get(i).getDayOfWeek())&&
                    tRoomLesson.getGroup().getId()==tRoomLessons.get(i).getGroup().getId()){
                return "redirect:/manage_groups?operation=fail";
            }
        }
        tRoomLessonRepository.save(tRoomLesson);
        return "redirect:/manage_groups?operation=accepted";
    }

    @RequestMapping(value = "/manage_subjects",method = RequestMethod.GET)
    public ModelAndView manageSubjects(@RequestParam(name = "smessage",required = false) String message){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("userClickManageSubjects", true);
        SubmitSemesterModel submitSemesterModel = new SubmitSemesterModel();
        mv.addObject("semesterModel",submitSemesterModel);
        mv.addObject("title","Manage Subjects");

        if (message!=null){

            if (message.equals("server")){
                mv.addObject("smessage","Server faced with error while submitting your application!");
            }else if (message.equals("success")){
                mv.addObject("smessage","You have successfully submit your semi-semester application! ");
            }else if (message.equals("noseat")){
                mv.addObject("smessage"," There are no enough seats in this auditory, Please choose another day or professor!");
            }

            System.out.println(message+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
        return mv;
    }

    @RequestMapping("/news")
    public ModelAndView news(){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("userClickNews", true);
        mv.addObject("title","News");
        return mv;
    }


    @ModelAttribute("groups")
    public List<Group> getGroups(){
        return groupRepository.findAll();
    }
    @ModelAttribute("group")
    public Group getGroup(){
        return new Group();
    }

    @ModelAttribute("rooms")
    public List<Rooms> getRooms(){
        return roomRepository.findAll();
    }
    @ModelAttribute("room")
    public Rooms getRoom(){
        return new Rooms();
    }

    @ModelAttribute("lessons")
    public List<Lesson> getLessons(){
        return lessonRepository.findAll();
    }
    @ModelAttribute("lesson")
    public Lesson getLesson(){
        return new Lesson();
    }



}
