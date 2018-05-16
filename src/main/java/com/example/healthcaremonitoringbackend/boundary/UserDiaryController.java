package com.example.healthcaremonitoringbackend.boundary;


import com.example.healthcaremonitoringbackend.entity.*;
import com.example.healthcaremonitoringbackend.model.QuantityFood;
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
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/userdiary")
public class UserDiaryController {

    public static final Logger LOG = Logger.getLogger(UserDiaryController.class.getName());

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
        DayFood dayFood = day_FoodRepository.findDayFoodByDayIdAndFoodId(day.getId(), food.getId());
        UserDiary userDiary = new UserDiary();
        userDiary.setDayFood(dayFood);
        userDiary.setUser(user);
        userDiary.setQuantity(quantity);
        userDiaryRepository.save(userDiary);

        LOG.info("UserDiary Saved");
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
        if (day != null && food != null)
            if (day_FoodRepository.findDayFoodByDayIdAndFoodId(day.getId(), food.getId()) != null) {
                DayFood dayFood = day_FoodRepository.findDayFoodByDayIdAndFoodId(day.getId(), food.getId());

                UserDiary userDiaryForReturn = userDiaryRepository.findUserDiaryByDayFoodAndUser(dayFood, user);

                return userDiaryForReturn;
            }
        return null;
    }

    @PostMapping(path = "/allUserDiaryAfterDayAndUser")
    public @ResponseBody
    List<UserDiary> getAllUserDiaryAfterDayAndUser(@RequestParam String dateString, String username) throws ParseException {

        List<UserDiary> userDiaryList = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(df.parse(dateString));
        Day day = dayRepository.findDayByDate(cal);

        List<DayFood> listDayFood = day_FoodRepository.findAllByDayId(day.getId());
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

        UserDiary oldUserDiary = userDiaryRepository.findUserDiaryById(id);
        oldUserDiary.setQuantity(quantity);

        userDiaryRepository.save(oldUserDiary);
        return "Updated quantity for an existing userDiary";

    }

    @PostMapping(path = "/updateUserDiaryQuantity")
    public @ResponseBody
    String updateUserDiaryQuantity2(@RequestParam double quantity, @RequestParam String dateString, String foodName, String username) throws ParseException {

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(df.parse(dateString));

        Day day = dayRepository.findDayByDate(cal);
        Food food = foodRepository.findFoodByFoodname(foodName);
        DayFood dayFood = day_FoodRepository.findDayFoodByDayIdAndFoodId(day.getId(), food.getId());
        User user = userRepository.findUserByUsername(username);
        UserDiary userDiary = userDiaryRepository.findUserDiaryByDayFoodAndUser(dayFood, user);
        userDiary.setQuantity(quantity);
        userDiaryRepository.save(userDiary);
        LOG.info("Updated quantity for an existing userDiary");
        return "Updated quantity for an existing userDiary";

    }

    @PostMapping(path = "/searchUserDiary")
    public @ResponseBody
    UserDiary getUserDiary(@RequestParam DayFood dayFood, @RequestParam User user) throws ParseException {

        LOG.info("Get userDiary by dayFood and user");
        return userDiaryRepository.findUserDiaryByDayFoodAndUser(dayFood, user);
    }

    @PostMapping(path = "/searchUserDiary2")
    public @ResponseBody
    UserDiary getUserDiary(@RequestParam Long idDayFood, @RequestParam String username) throws ParseException {

        DayFood dayFood = day_FoodRepository.findDayFoodById(idDayFood);
        User user = userRepository.findUserByUsername(username);
        LOG.info("Get userDiary by idDayFood and username");
        return userDiaryRepository.findUserDiaryByDayFoodAndUser(dayFood, user);
    }

    @PostMapping(path = "/delete")
    public @ResponseBody
    String deleteUserDiary(@RequestParam Long idUserDiary) {
        UserDiary userDiary = userDiaryRepository.findUserDiaryById(idUserDiary);
        userDiaryRepository.delete(userDiary);
        LOG.info("UserDiary deleted");
        return "UserDiary deleted";

    }

    @PostMapping(path = "/getAllFoodsFromThisDay")
    public @ResponseBody
    List<Food> getFoods(@RequestParam String dateString, @RequestParam String username) throws ParseException {

        List<DayFood> dayFoodList = new ArrayList<>();
        List<Food> foodList = new ArrayList<>();

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(df.parse(dateString));
        if (dayRepository.findDayByDate(cal) != null) {
            Day day = dayRepository.findDayByDate(cal);

            User user = userRepository.findUserByUsername(username);
            List<UserDiary> listUserDiary = userDiaryRepository.findAllByUser(user);

            for (UserDiary userdiary : listUserDiary) {

                dayFoodList.add(userdiary.getDayFood());
            }

            for (DayFood dayFood : dayFoodList) {
                if (dayFood.getDayId() == day.getId()) {
                    Food myFood = foodRepository.findFoodById(dayFood.getFoodId());
                    foodList.add(myFood);
                }

            }
        }

        LOG.info("Get all food from this day");
        return foodList;

    }

    @PostMapping(path = "/getQuantityFoodTodayFromUser")
    public @ResponseBody
    List<QuantityFood> getQuantityFood(@RequestParam String dateString, String username) throws ParseException {

        List<UserDiary> userDiaryList = new ArrayList<>();
        List<QuantityFood> quantityFoodList = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(df.parse(dateString));
        Day day = dayRepository.findDayByDate(cal);

        List<DayFood> listDayFood = day_FoodRepository.findAllByDayId(day.getId());
        User user = userRepository.findUserByUsername(username);

        for (DayFood dayFood : listDayFood) {
            UserDiary userDiary = userDiaryRepository.findUserDiaryByDayFoodAndUser(dayFood, user);
            if (userDiary != null)
                userDiaryList.add(userDiary);
        }

        for (UserDiary userDiaryItem : userDiaryList) {
            Food foodSelected = foodRepository.findFoodById(userDiaryItem.getDayFood().getFoodId());
            quantityFoodList.add(new QuantityFood(foodSelected, userDiaryItem.getQuantity()));

        }
        return quantityFoodList;
    }

}
