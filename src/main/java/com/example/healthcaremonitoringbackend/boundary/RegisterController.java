package com.example.healthcaremonitoringbackend.boundary;

import com.example.healthcaremonitoringbackend.entity.User;
import com.example.healthcaremonitoringbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/register")
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewUser(@RequestBody User user) {

        userRepository.save(user);
        return "Saved";

    }

//    @PostMapping(path = "/addD")
//    public @ResponseBody
//    String addNewUser(@RequestParam String username, @RequestParam String password, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String gender, @RequestParam int height, @RequestParam int weight) {
//
////        userRepository.save(user);
////        return "Saved";
//
//    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @PostMapping(path = "/searchUser")
    public @ResponseBody
    User getUser(@RequestParam String username, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String password, @RequestParam String gender, @RequestParam String email) {
        return userRepository.findUserByUsernameAndFirstNameAndLastNameAndPasswordAndGenderAndEmail(username, firstName, lastName, password, gender, email);
    }

    @PostMapping(path = "/searchUserByUsername")
    public @ResponseBody
    User getUser(@RequestParam String username) {
        return userRepository.findUserByUsername(username);
    }


}
