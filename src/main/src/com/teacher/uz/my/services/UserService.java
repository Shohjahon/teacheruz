package com.teacher.uz.my.services;

import com.teacher.uz.my.domains.User;
import com.teacher.uz.my.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shoh Jahon on 12.04.2018.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        users = userRepository.findAll();
        return users;
    }

    public User getUser(Long id) {
        return userRepository.findOne(id);
    }
    public void saveUser(User user){
        userRepository.save(user);
    }
    public void deleteUser(Long id){
        User user = userRepository.findOne(id);
        user.setActive(false);
        userRepository.save(user);
    }

    public List<User> getUsersByRole(String role){
        return userRepository.findUsersByRole(role);
    }
    public User getUserByEmail(String email){
        return userRepository.getUserByEmail(email);
    }
}
