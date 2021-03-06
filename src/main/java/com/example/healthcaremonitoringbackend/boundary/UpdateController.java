package com.example.healthcaremonitoringbackend.boundary;


import com.example.healthcaremonitoringbackend.entity.User;
import com.example.healthcaremonitoringbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping(path = "/update")
public class UpdateController {

    public static final Logger LOG = Logger.getLogger(UpdateController.class.getName());

    @Autowired
    private UserRepository userRepository;


    @PostMapping(path = "/update")
    public @ResponseBody
    String updateUser(@RequestBody User user) {

        User oldUser = userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setGender(user.getGender());
        oldUser.setHeight(user.getHeight());
        oldUser.setWeight(user.getWeight());
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setAge(user.getAge());
        oldUser.setContactNo(user.getContactNo());
        oldUser.setEmail(user.getEmail());
        userRepository.save(oldUser);
        LOG.info("Updated user");
        return "Updated user";

    }

    @PostMapping(path = "/updateWeightHeight")
    public @ResponseBody
    String updateUserWH(@RequestBody User user) {

        User oldUser = userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        oldUser.setHeight(user.getHeight());
        oldUser.setWeight(user.getWeight());
        userRepository.save(oldUser);
        LOG.info("Updated height and width");
        return "Updated height and width";

    }

    @PostMapping(path = "/updatee2")
    public @ResponseBody
    String updateUser22(@RequestParam String username, @RequestParam String password, @RequestParam int height, @RequestParam int weight) {

        User oldUser = userRepository.findUserByUsernameAndPassword(username, password);
        oldUser.setHeight(height);
        oldUser.setWeight(weight);

        LOG.info("Updated user hight and width");
        userRepository.save(oldUser);
        return "Updated user hight and width";

    }

    @PostMapping(path = "/updateAutentificationDates")
    public @ResponseBody
    String updateUserAutentification(@RequestParam String username, @RequestParam String password, @RequestParam String newUsername, @RequestParam String newPassword) {


        LOG.log(Level.INFO, "Update auth {0} {1} ", new Object[]{username, password});
        User oldUser = userRepository.findUserByUsernameAndPassword(username, password);
        oldUser.setUsername(newUsername);
        oldUser.setPassword(newPassword);

        userRepository.save(oldUser);
        LOG.info("Updated autentification dates");
        return "Updated autentification dates";

    }

    @PostMapping(path = "/updatee")
    public @ResponseBody
    String updateUser2(@RequestParam(name = "user_name") String username, @RequestParam String password, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String gender, @RequestParam int height, @RequestParam int weight, @RequestParam int age, @RequestParam String email, @RequestParam String contactNo) {

        User oldUser = userRepository.findUserByUsernameAndPassword(username, password);
        oldUser.setUsername(username);
        oldUser.setPassword(password);
        oldUser.setGender(gender);
        oldUser.setHeight(height);
        oldUser.setWeight(weight);
        oldUser.setFirstName(firstName);
        oldUser.setLastName(lastName);
        oldUser.setAge(age);
        oldUser.setContactNo(contactNo);
        oldUser.setEmail(email);
        userRepository.save(oldUser);
        LOG.info("Updated user");
        return "Updated user";

    }

    @PostMapping(path = "/updateStepsObjective")
    public @ResponseBody
    String updateStepsObjective(@RequestParam String username, @RequestParam String password, @RequestParam double stepsObjective) {

        User oldUser = userRepository.findUserByUsernameAndPassword(username, password);
        oldUser.setStepsObjective(stepsObjective);
        userRepository.save(oldUser);
        LOG.info("Updated steps objective");
        return "Updated steps objective";

    }
}
