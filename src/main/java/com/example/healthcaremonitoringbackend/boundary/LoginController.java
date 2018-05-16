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

    public static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserRepository userRepository;// = new UserRepository();

    @PostMapping(path = "/login")
    public @ResponseBody
    //@RequestParam(name = "user_name") String username, @RequestParam String password
    User getUser(@RequestBody User user) {
        LOG.info("Performing user login");
        LOG.debug("Performing user login");
        return userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());

    }

    @PostMapping(path = "/loginWithParams")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    User getUser(@RequestParam String username, @RequestParam String password) {
        LOG.info("Performing user login");
        return userRepository.findUserByUsernameAndPassword(username, password);
    }

}