package com.example.healthcaremonitoringbackend.boundary;


import com.example.healthcaremonitoringbackend.entity.*;
import com.example.healthcaremonitoringbackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/userdiary")
public class UserDiaryController {
    @Autowired
    private Day_FoodRepository day_FoodRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DayRepository dayRepository;

    @Autowired
    private UserDiaryRepository userDiaryRepository;

    @Autowired
    private FoodRepository foodRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewUserDiary(@RequestParam String dateString, @RequestParam String nameFood, @RequestParam String username, @RequestParam double quantity) throws ParseException {

        User user = userRepository.findUserByUsername(username);
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(df.parse(dateString));

        Day day = dayRepository.findDayByDate(cal);
        Food food = foodRepository.findFoodByFoodname(nameFood);
        DayFood dayFood = day_FoodRepository.findDayFoodByDayAndFood(day, food);
        UserDiary userDiary = new UserDiary();
        userDiary.setDayFood(dayFood);
        userDiary.setUser(user);
        userDiary.setQuantity(quantity);
        userDiaryRepository.save(userDiary);

        return "UserDiary Saved";

    }

    @PostMapping(path = "/returnUserDiary")
    public @ResponseBody
    UserDiary getUserDiary(@RequestParam String dateString, @RequestParam String nameFood, @RequestParam String username) throws ParseException {

        User user = userRepository.findUserByUsername(username);
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(df.parse(dateString));

        Day day = dayRepository.findDayByDate(cal);
        Food food = foodRepository.findFoodByFoodname(nameFood);
        DayFood dayFood = day_FoodRepository.findDayFoodByDayAndFood(day, food);

        UserDiary userDiaryForReturn = userDiaryRepository.findUserDiaryByDayFoodAndUser(dayFood, user);

        return userDiaryForReturn;
    }

    @PostMapping(path = "/allUserDiaryAfterDayAndUser")
    public @ResponseBody
    List<UserDiary> getAllUserDiaryAfterDayAndUser(@RequestParam String dateString, String username) throws ParseException {

        List<UserDiary> userDiaryList = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(df.parse(dateString));
        Day day = dayRepository.findDayByDate(cal);

        List<DayFood> listDayFood = day_FoodRepository.findAllByDay(day);
        User user = userRepository.findUserByUsername(username);

        for (DayFood dayFood : listDayFood) {
            UserDiary userDiary = userDiaryRepository.findUserDiaryByDayFoodAndUser(dayFood, user);
            if (userDiary != null)
                userDiaryList.add(userDiary);
        }
        return userDiaryList;
    }

    @PostMapping(path = "/updateUserDiary")
    public @ResponseBody
    String updateUserDiaryQuantity(@RequestParam double quantity, @RequestParam Long id) {

        UserDiary oldUserDiary= userDiaryRepository.findUserDiaryById(id);
        oldUserDiary.setQuantity(quantity);

        userDiaryRepository.save(oldUserDiary);
        return "Updated quantity for an existing userDiary";

    }

}
