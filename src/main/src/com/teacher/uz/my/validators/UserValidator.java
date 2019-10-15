package com.teacher.uz.my.validators;

import com.teacher.uz.my.domains.User;
import com.teacher.uz.my.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Shoh Jahon on 12.04.2018.
 */
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        if (user.getThumbnail() == null ||
                user.getThumbnail().getOriginalFilename().equals("")){
            errors.rejectValue("thumbnail",null,"Please select image file to upload!");
            return;
        }

        if (!(user.getThumbnail().getContentType().equals("image/jpeg")||
                (user.getThumbnail().getContentType().equals("image/png"))||
                (user.getThumbnail().getContentType().equals("image/gif"))
        )){
            errors.rejectValue("thumbnail",null,"Please use only image file for upload!");
            return;
        }

        if (!user.getPassword().equals(user.getConfirmPassword())){
            errors.rejectValue("confirmPassword",null,"The password does not match confirmed password!");
            return;
        }
    }
}
