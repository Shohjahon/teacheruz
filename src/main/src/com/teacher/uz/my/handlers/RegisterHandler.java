package com.teacher.uz.my.handlers;

import com.teacher.uz.my.domains.Field;
import com.teacher.uz.my.domains.University;
import com.teacher.uz.my.domains.User;
import com.teacher.uz.my.services.FieldService;
import com.teacher.uz.my.services.UniversityService;
import com.teacher.uz.my.services.UserService;
import com.teacher.uz.my.viewmodel.RegisterModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


/**
 * Created by Shoh Jahon on 13.04.2018.
 */
@Component
public class RegisterHandler {
    @Autowired
    private UserService userService;
    @Autowired
    private UniversityService universityService;
    @Autowired
    private FieldService fieldService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(RegisterHandler.class);

    public RegisterModel init(){
        return new RegisterModel();
    }

    public void addUser(RegisterModel registerModel, User user){
        registerModel.setUser(user);
    }
    public void setUniversity(RegisterModel registerModel, University university){
        registerModel.setUniversity(university);
    }
    public void setField(RegisterModel registerModel,Field field){
        registerModel.setField(field);
    }

    public String saveAll(RegisterModel model){
        String transitionValue = "success";
        User user  = model.getUser();

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userService.saveUser(user);

        return transitionValue;

    }

    public String validateUser(User user, MessageContext error){
        String transitionValue = "success";

        if (!(user.getPassword().equals(user.getConfirmPassword()))){
            error.addMessage(new MessageBuilder().
                    error().
                    source("confirmPassword").
                    defaultText("Password does not match the confirm password!").
                    build());
            transitionValue = "failure";
        }

        if (userService.getUserByEmail(user.getEmail())!=null){
            error.addMessage(new MessageBuilder().
                    error().
                    source("email").
                    defaultText("Email address is already used!").
                    build());
            transitionValue = "failure";
        }
        return transitionValue;
    }
}
