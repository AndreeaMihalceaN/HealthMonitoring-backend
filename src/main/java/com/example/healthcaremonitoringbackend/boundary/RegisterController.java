package com.example.healthcaremonitoringbackend.boundary;

import com.example.healthcaremonitoringbackend.control.LoginService;
import com.example.healthcaremonitoringbackend.entity.User;
import com.example.healthcaremonitoringbackend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/register") // This means URL's start with /demo (after Application path)
@ResponseStatus(HttpStatus.CREATED)
public class RegisterController {

    //private static final Logger LOG = LoggerFactory.getLogger(VacancyController.class);

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewUser (@RequestParam String username, @RequestParam String password, @RequestParam String firstName
            ,@RequestParam String lastName, @RequestParam String gender, @RequestParam int height, @RequestParam int weight) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setUsername(username);
        user.setGender(gender);
        user.setHeight(height);
        user.setWeight(weight);

        userRepository.save(user);
        return "Saved";

    }

//    @Autowired
//    private LoginService loginService;
//
//    @PostMapping("/login")
//    public LoginService.UserInfo login(@RequestBody @Valid User user) {
//        LOG.info("User {} signed in", user.getUsername());
//        return loginService.getUser(user);
//    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}
