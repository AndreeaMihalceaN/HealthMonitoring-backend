package com.example.healthcaremonitoringbackend.boundary;

import com.example.healthcaremonitoringbackend.entity.User;
import com.example.healthcaremonitoringbackend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/register")
public class RegisterController {

    public static final Logger LOG = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewUser(@RequestBody User user) {

        userRepository.save(user);
        LOG.info("Register a new user");
        LOG.debug("Was saved a new user");
        return "Saved";

    }

    @PostMapping(path = "/addUsername")
    public @ResponseBody
    String addNewUser(@RequestBody String username) {

        User user = new User();
        user.setUsername(username);
        userRepository.save(user);
        LOG.info("Register a new user with username");
        LOG.debug("Was saved a new user");
        return "Saved";

    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        LOG.info("Get all users");
        LOG.debug("Get all users");
        return userRepository.findAll();
    }

    @GetMapping(path = "/all2")
    public @ResponseBody
    List<User> getAllUsers2() {
        // This returns a JSON or XML with the users
        LOG.info("Get all users");
        LOG.debug("Get all users");
        return userRepository.findAll();
    }

    @PostMapping(path = "/searchUser")
    public @ResponseBody
    User getUser(@RequestParam String username, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String password, @RequestParam String gender, @RequestParam String email) {
        LOG.info("Get user by username, firstName, lastName, password, gender, email");
        return userRepository.findUserByUsernameAndFirstNameAndLastNameAndPasswordAndGenderAndEmail(username, firstName, lastName, password, gender, email);
    }

    @PostMapping(path = "/searchUserByUsername")
    public @ResponseBody
    User getUser(@RequestParam String username) {
        LOG.info("Get user by username");
        LOG.debug("Search user by username");
        return userRepository.findUserByUsername(username);
    }


}
