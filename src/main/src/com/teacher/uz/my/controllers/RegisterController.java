package com.teacher.uz.my.controllers;

import com.teacher.uz.my.domains.Field;
import com.teacher.uz.my.domains.University;
import com.teacher.uz.my.domains.UniversityFieldUser;
import com.teacher.uz.my.domains.User;
import com.teacher.uz.my.services.FieldService;
import com.teacher.uz.my.services.UniversityService;
import com.teacher.uz.my.services.UserService;
import com.teacher.uz.my.utilities.FileUploadUtility;
import com.teacher.uz.my.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by Shoh Jahon on 14.05.2018.
 */
@Controller
public class RegisterController {
    @Autowired
    private UserService userService;
    @Autowired
    private UniversityService universityService;
    @Autowired
    private FieldService fieldService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView registerPage(@RequestParam(name = "operation",required = false) String operation){
        ModelAndView mv = new ModelAndView("sign_up");
        User user = new User();
        user.setId(Long.valueOf(0));
        user.setActive(true);
        mv.addObject("user",user);
        mv.addObject("title","User Registration");

        if (operation != null){
            if (operation.equals("user")){
                mv.addObject("message","User Submitted Successfully!");
            }
        }
        return mv;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String handleUserSubmission(@Valid @ModelAttribute("user") User user,
                                       BindingResult result, Model model,
                                          HttpServletRequest request){

        new UserValidator().validate(user,result);

        //Xatoliklarga tekshirish
        if(result.hasErrors()){
            model.addAttribute("title","Manage Products");
            model.addAttribute("messagefail","Validation failed for User Submission!");
            return "sign_up";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User user1 = userService.getUserByEmail(user.getEmail());
        if (user1!=null){
            model.addAttribute("messagefail","This email address have already token!");
            return "sign_up";
        }

        userService.saveUser(user);


        if (!user.getThumbnail().getOriginalFilename().equals("")){
            FileUploadUtility.uploadFile    (request, user.getThumbnail(), user.getCode());
        }


        return "redirect:/register?operation=user";
    }

}
