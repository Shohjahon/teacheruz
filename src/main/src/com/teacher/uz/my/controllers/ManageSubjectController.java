package com.teacher.uz.my.controllers;

import com.teacher.uz.my.domains.*;
import com.teacher.uz.my.repositories.*;
import com.teacher.uz.my.services.UserService;
import com.teacher.uz.my.viewmodel.Response;
import com.teacher.uz.my.viewmodel.ScheduleModel;
import com.teacher.uz.my.viewmodel.SubmitSemesterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Shoh Jahon on 19.05.2018.
 */
@Controller
public class ManageSubjectController {
    @Autowired
    private UserService userService;
    @Autowired
    private TRoomLessonRepository tRoomLessonRepository;
    @Autowired
    private StudentTLessonRepository studentTLessonRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private LessonRepository lessonRepository;

    @RequestMapping(value = "/manage_subjects",method = RequestMethod.POST)
    public String handleSemesterSubmission(@RequestBody SubmitSemesterModel submitSemesterModel){
        System.out.println(submitSemesterModel.toString());
        User student = userService.getUserByEmail(submitSemesterModel.getEmail());
        TRoomLesson tRoomLesson = tRoomLessonRepository.findOne(Long.valueOf(submitSemesterModel.getSchedule_id()));
        StudentTLesson studentTLesson = new StudentTLesson();
        if (student == null || tRoomLesson ==null){
            return "redirect:/manage_subjects?smessage=server";
        }

        int currentSeats = tRoomLesson.getNumberOfStudents();
        int overallSeats = tRoomLesson.getRoom().getSeats();
        currentSeats = currentSeats + 1;
        if (currentSeats<=overallSeats){
            tRoomLesson.setNumberOfStudents(currentSeats);
            tRoomLessonRepository.save(tRoomLesson);
            studentTLesson.setStudent(student);
            studentTLesson.settRoomLesson(tRoomLesson);
            studentTLessonRepository.save(studentTLesson);
            return "redirect:/manage_subjects?smessage=success";
        }

            return "redirect:/manage_subjects?smessage=noseat";

    }

    @RequestMapping(value = "/save/schedule",method = RequestMethod.POST)
    @ResponseBody
    public Response postSchedule(@RequestBody ScheduleModel scheduleModel){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>"+scheduleModel.toString());
        Response response = new Response();
        System.out.println(scheduleModel.toString());
        List<TRoomLesson> tRoomLessons = tRoomLessonRepository.findTRoomLessonsByUserId(Long.valueOf(scheduleModel.getUserId()));
        if (tRoomLessons != null){
            boolean haveCoinside = false;
            for (int i = 0; i < tRoomLessons.size(); i++) {
                TRoomLesson tRoomLesson = tRoomLessons.get(i);
                long roomId = tRoomLesson.getRoom().getId();
                String dayOfWeek = tRoomLesson.getDayOfWeek();
                int pair = tRoomLesson.getPair();

                if (scheduleModel.getDayOfWeek().equals(dayOfWeek) &&
                        scheduleModel.getRoomId() == roomId &&
                        scheduleModel.getPair() == pair){
                    haveCoinside = true;
                    response.setStatus("The Room, day of the week and pair you have chosen is similar to other schedule,Please choose another one!");
                    return response;
                }
            }
            if (haveCoinside!=true){
                Rooms room = roomRepository.findOne(Long.valueOf(scheduleModel.getRoomId()));
                Group group = groupRepository.findOne(Long.valueOf(scheduleModel.getGroupId()));
                Lesson lesson = lessonRepository.findOne(Long.valueOf(scheduleModel.getSubjectId()));
                User user = userService.getUser(Long.valueOf(scheduleModel.getUserId()));
                TRoomLesson tRoomLesson = new TRoomLesson();
                tRoomLesson.setUser(user);
                tRoomLesson.setDayOfWeek(scheduleModel.getDayOfWeek());
                tRoomLesson.setGroup(group);
                tRoomLesson.setLesson(lesson);
                tRoomLesson.setRoom(room);
                tRoomLesson.setNumberOfStudents(0);
                tRoomLesson.setPair(scheduleModel.getPair());
                tRoomLessonRepository.save(tRoomLesson);
                response.setStatus("You have successfully submitted new schedule for the upcoming semester!");
                return response;
            }
        }
        Rooms room = roomRepository.findOne(Long.valueOf(scheduleModel.getRoomId()));
        Group group = groupRepository.findOne(Long.valueOf(scheduleModel.getGroupId()));
        Lesson lesson = lessonRepository.findOne(Long.valueOf(scheduleModel.getSubjectId()));
        User user = userService.getUser(Long.valueOf(scheduleModel.getUserId()));
        TRoomLesson tRoomLesson = new TRoomLesson();
        tRoomLesson.setUser(user);
        tRoomLesson.setDayOfWeek(scheduleModel.getDayOfWeek());
        tRoomLesson.setGroup(group);
        tRoomLesson.setLesson(lesson);
        tRoomLesson.setRoom(room);
        tRoomLesson.setNumberOfStudents(0);
        tRoomLesson.setPair(scheduleModel.getPair());
        tRoomLessonRepository.save(tRoomLesson);
        response.setStatus("You have successfully submitted new schedule for the upcoming semester!");

         return response;
    }

}
