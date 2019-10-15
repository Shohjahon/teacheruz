package com.teacher.uz.my.controllers;

import com.teacher.uz.my.domains.Field;
import com.teacher.uz.my.domains.University;
import com.teacher.uz.my.domains.UniversityField;
import com.teacher.uz.my.domains.User;
import com.teacher.uz.my.services.FieldService;
import com.teacher.uz.my.services.UniversityFieldService;
import com.teacher.uz.my.services.UniversityService;
import com.teacher.uz.my.services.UserService;
import com.teacher.uz.my.utilities.FileUploadUtility;
import com.teacher.uz.my.validators.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;

import java.util.ArrayList;
import java.util.List;

import static com.teacher.uz.my.domains.enumerations.TableNames.field;
import static com.teacher.uz.my.domains.enumerations.TableNames.university;
import static com.teacher.uz.my.domains.enumerations.TableNames.user;

/**
 * Created by Shoh Jahon on 12.04.2018.
 */
@Controller
@RequestMapping("/mydashboard")
public class DashboardController {
    @Autowired
    private UserService userService;
    @Autowired
    private UniversityService universityService;
    @Autowired
    private FieldService fieldService;
    @Autowired
    private UniversityFieldService universityFieldService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private Logger logger = LoggerFactory.getLogger(DashboardController.class);


    @RequestMapping(value = "/create/user", method = RequestMethod.GET)
    public ModelAndView showGenericModel(){
        ModelAndView mv = new ModelAndView("dashboard");
        User user  = new User();
        user.setActive(true);
        user.setId(Long.valueOf(0));
        mv.addObject("admin_user",user);
        mv.addObject("userClickCreateUser",true);
        return mv;
    }

    @RequestMapping(value = "/create/{id}/user", method = RequestMethod.GET)
    public ModelAndView showEditProduct(@PathVariable int id){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickCreateUser",true);
        mv.addObject("title","Update User");
        User user = userService.getUser(Long.valueOf(id));
        mv.addObject("admin_user",user);
        return mv;
    }

    @RequestMapping(value = "/create/user",method = RequestMethod.POST)
    public String handleUserSubmission(@ModelAttribute("admin_user") User user,
                                       Model model,
                                       HttpServletRequest request){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);

        logger.debug(user.getThumbnail().getName());
        if (!user.getThumbnail().getOriginalFilename().equals("")){
            FileUploadUtility.uploadFile(request,user.getThumbnail(),user.getCode());
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/user/{id}/activation", method = RequestMethod.POST)
    @ResponseBody
    public String handleUserActivation(@PathVariable int id){
        User user = userService.getUser(Long.valueOf(id));
        boolean isActive = user.isActive();

        user.setActive(!user.isActive());
        userService.saveUser(user);

        return isActive?"You have successfully deactivated user with id " + user.getId():
                "You have successfully activated user with id "+user.getId();
    }


    //University

    @RequestMapping(value = "/universities",method = RequestMethod.GET)
    public ModelAndView showManageUniversities(){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickUniversityList",true);
        mv.addObject("title","Dashboard - University Management");
        return mv;
    }

    @RequestMapping(value = "/create/{id}/university", method = RequestMethod.GET)
    public ModelAndView showEditUniversity(@PathVariable int id){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickCreateUniversity",true);
        mv.addObject("title","Update University");
        University university = universityService.getUniversity(Long.valueOf(id));
        mv.addObject("university",university);
        return mv;
    }

    @RequestMapping(value = "/create/university", method = RequestMethod.GET)
    public ModelAndView showCreateUniversity(){
        ModelAndView mv = new ModelAndView("dashboard");
        University university = new University();
        university.setId(Long.valueOf(0));
        mv.addObject("university",university);
        mv.addObject("userClickCreateUniversity",true);
        return mv;
    }
    @RequestMapping(value = "/create/university", method = RequestMethod.POST)
    public String showCreateUniversity(@ModelAttribute("university") University university){
        universityService.saveUniversity(university);
        return "redirect:/mydashboard/universities";
    }

    @RequestMapping(value = "/delete/{id}/university", method = RequestMethod.POST)
    @ResponseBody
    public String handleUniversityDeletion(@PathVariable int id){
        universityService.deleteUniversity(Long.valueOf(id));
        return "You have successfully removed this university!";
    }
    //University end


//    Field start


    @RequestMapping(value = "/fields",method = RequestMethod.GET)
    public ModelAndView showManageFields(){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickFieldList",true);
        mv.addObject("title","Dashboard - Field Management");
        return mv;
    }

    @RequestMapping(value = "/create/{id}/field", method = RequestMethod.GET)
    public ModelAndView showEditField(@PathVariable int id){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickCreateField",true);
        mv.addObject("title","Update Field");
        Field field = fieldService.getField(Long.valueOf(id));
        mv.addObject("field",field);
        return mv;
    }

    @RequestMapping(value = "/create/field", method = RequestMethod.GET)
    public ModelAndView showCreateField(){
        ModelAndView mv = new ModelAndView("dashboard");
        Field field = new Field();
        field.setId(Long.valueOf(0));
        mv.addObject("field",field);
        mv.addObject("userClickCreateField",true);
        return mv;
    }
    @RequestMapping(value = "/create/field", method = RequestMethod.POST)
    public String showCreateField(@ModelAttribute("field") Field field){
        fieldService.saveField(field);
        return "redirect:/mydashboard/fields";
    }

    @RequestMapping(value = "/delete/{id}/field", method = RequestMethod.POST)
    @ResponseBody
    public String handleFieldDeletion(@PathVariable int id){
        fieldService.deleteField(Long.valueOf(id));
        return "You have successfully removed this field!";
    }

//    Field end

//    Universuty Field start


    @RequestMapping(value = "/university_field",method = RequestMethod.GET)
    public ModelAndView showManageUniversityField(){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickUniversityFieldList",true);
        mv.addObject("title","Dashboard - University Field Management");
        return mv;
    }

    @RequestMapping(value = "/create/{id}/university_field", method = RequestMethod.GET)
    public ModelAndView showEditUniversityField(@PathVariable int id){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickCreateUniversityField",true);
        mv.addObject("title","Update University Field");
        UniversityField universityField = universityFieldService.getUniversityField(id);
        mv.addObject("universityField",universityField);
        return mv;
    }

    @RequestMapping(value = "/create/university_field", method = RequestMethod.GET)
    public ModelAndView showCreateUniversityField(){
        ModelAndView mv = new ModelAndView("dashboard");
        UniversityField universityField = new UniversityField();
        mv.addObject("universityField",universityField);
        mv.addObject("title","Dashboard - University Field Management");
        mv.addObject("userClickCreateUniversityField",true);
        return mv;
    }
    @RequestMapping(value = "/create/university_field", method = RequestMethod.POST)
    public String showCreateUniversityField(@ModelAttribute("universityField") UniversityField universityField){
        universityFieldService.saveUniversityField(universityField);
        return "redirect:/mydashboard/university_field";
    }

    @RequestMapping(value = "/delete/{id}/university_field", method = RequestMethod.POST)
    @ResponseBody
    public String handleUniversiytFieldDeletion(@PathVariable int id){
        UniversityField universityField = universityFieldService.getUniversityField(id);
        boolean isActive = universityField.isActive();
        universityField.setActive(!isActive);
        universityFieldService.saveUniversityField(universityField);
        return isActive?"You have successfully deactivated university field with id " + universityField.getId():
                "You have successfully activated university field with id "+universityField.getId();
    }

    @ModelAttribute("universities")
    public List<University> getUniversities(){
        return universityService.getAllUniversities();
    }
    @ModelAttribute("university")
    public University getUniverstiy(){
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


//    University Field end
}
