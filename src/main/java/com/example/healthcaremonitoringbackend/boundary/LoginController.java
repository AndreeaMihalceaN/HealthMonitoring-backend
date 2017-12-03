package com.example.healthcaremonitoringbackend.boundary;

import com.example.healthcaremonitoringbackend.control.LoginService;
import com.example.healthcaremonitoringbackend.entity.User;
import com.example.healthcaremonitoringbackend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;// = new UserRepository();

    @PostMapping(path = "/login")
    public @ResponseBody
    //@RequestParam(name = "user_name") String username, @RequestParam String password
    User getUser(@RequestBody User user) {
        return userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @PostMapping(path = "/loginWithParams")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    User getUser2(@RequestParam String username, @RequestParam String password) {
        return userRepository.findUserByUsernameAndPassword(username, password);
    }

}