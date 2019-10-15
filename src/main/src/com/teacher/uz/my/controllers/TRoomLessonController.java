package com.teacher.uz.my.controllers;

import com.teacher.uz.my.domains.*;
import com.teacher.uz.my.repositories.GroupRepository;
import com.teacher.uz.my.repositories.LessonRepository;
import com.teacher.uz.my.repositories.RoomRepository;
import com.teacher.uz.my.repositories.TRoomLessonRepository;
import com.teacher.uz.my.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

import static com.teacher.uz.my.domains.enumerations.TableNames.test;

/**
 * Created by Shoh Jahon on 18.05.2018.
 */
@Controller
@RequestMapping("/teacher_room_lesson")
public class TRoomLessonController {
    @Autowired
    private TRoomLessonRepository tRoomLessonRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private LessonRepository lessonRepository;

    @RequestMapping(value = "/teacher_room_lessons", method = RequestMethod.GET)
    public ModelAndView showManageTRoomLessons(){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickTeacherRoomLesson",true);
        mv.addObject("title", "Teacher Room Lesson");
        return mv;
    }

    @RequestMapping(value = "/create/teacher_room_lesson",method = RequestMethod.GET)
    public ModelAndView showCreateTRoomLesson(@RequestParam(name = "operation",required = false) String operation){
        ModelAndView mv = new ModelAndView("dashboard");
        TRoomLesson tRoomLesson = new TRoomLesson();
        mv.addObject("title","Teacher Room Lesson");
        mv.addObject("tRoomLesson",tRoomLesson);
        mv.addObject("userClickCreateTeacherRoomLesson",true);

        if (operation!=null){
            if (operation.equals("accepted")){
                mv.addObject("message","You have successfully submitted this plan!");
            }else if (operation.equals("fail")){
                mv.addObject("messagefail","The room you have chosen is not vacant now! Please choose other rooms or day!");
            }
        }
        return mv;
    }

    @RequestMapping(value = "/create/{id}/teacher_room_lesson",method = RequestMethod.GET)
    public ModelAndView showUpdateTRoomLesson(@PathVariable int id){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickCreateTeacherRoomLesson",true);
        mv.addObject("title","Update Teacher Room Lesson");
        TRoomLesson tRoomLesson = tRoomLessonRepository.findOne(Long.valueOf(id));
        mv.addObject("tRoomLesson",tRoomLesson);
        return mv;
    }
    @RequestMapping(value = "/create/teacher_room_lesson", method = RequestMethod.POST)
    public String showCreateTRoomLesson(@ModelAttribute("tRoomLesson") TRoomLesson tRoomLesson,
                                        BindingResult result, Model model){
        List<TRoomLesson> tRoomLessons = tRoomLessonRepository.findAll();
        System.out.println(tRoomLesson.toString());
        for (int i = 0; i < tRoomLessons.size(); i++) {
            if (tRoomLesson.getPair().equals(tRoomLessons.get(i).getPair())&&
                tRoomLesson.getDayOfWeek().equals(tRoomLessons.get(i).getDayOfWeek())&&
                tRoomLesson.getGroup().getId()==tRoomLessons.get(i).getGroup().getId()){
                return "redirect:/teacher_room_lesson/create/teacher_room_lesson?operation=fail";
            }
        }
        tRoomLessonRepository.save(tRoomLesson);
        return "redirect:/teacher_room_lesson/create/teacher_room_lesson?operation=accepted";
    }

    @RequestMapping(value = "/delete/{id}/teacher_room_lesson", method = RequestMethod.POST)
    @ResponseBody
    public String handleTRoomLessonDeletion(@PathVariable int id){
        tRoomLessonRepository.delete(Long.valueOf(id));
        return "You have successfully removed this Teacher Room Lesson!";
    }

    @ModelAttribute("users")
    public List<User> getTeachers(){
        List<User> teachers = userService.getUsersByRole("ADMIN");
        for (int i = 0; i <teachers.size() ; i++) {
            teachers.get(i).setFullName(teachers.get(i).getId()+"."+teachers.get(i).getLastName()+" "+teachers.get(i).getFirstName());
        }
        return teachers;
    }

    @ModelAttribute("user")
    public User getUser(){
        return new User();
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
