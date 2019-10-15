package com.teacher.uz.my.controllers;

import com.teacher.uz.my.domains.User;
import com.teacher.uz.my.services.UserService;
import com.teacher.uz.my.viewmodel.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

/**
 * Created by Shoh Jahon on 14.05.2018.
 */
@ControllerAdvice
public class GlobalController {
    @Autowired
    private HttpSession session;
    @Autowired
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(GlobalController.class);
    private UserModel userModel;

    @ModelAttribute("userModel")
    public UserModel getUserModel(){
        if (session.getAttribute("userModel")==null){

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = null;
            if (authentication != null){
                user = userService.getUserByEmail(authentication.getName());
            }

            if (user!=null){
                userModel = new UserModel();
                userModel.setId(user.getId());
                userModel.setEmail(user.getEmail());
                userModel.setRole(user.getRole());
                userModel.setCode(user.getCode());
                userModel.setFull_name(user.getLastName()+" "+user.getFirstName());

                session.setAttribute("userModel",userModel);

                return userModel;
            }
        }

        return (UserModel) session.getAttribute("userModel");
    }
}
