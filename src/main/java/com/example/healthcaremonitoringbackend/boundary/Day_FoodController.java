package com.example.healthcaremonitoringbackend.boundary;

import com.example.healthcaremonitoringbackend.entity.*;
import com.example.healthcaremonitoringbackend.repository.DayRepository;
import com.example.healthcaremonitoringbackend.repository.Day_FoodRepository;
import com.example.healthcaremonitoringbackend.repository.FoodRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@Controller
@RequestMapping(path = "/day_food")

public class Day_FoodController {
    public static final Logger LOG = LoggerFactory.getLogger(Day_FoodController.class);

    @Autowired
    private Day_FoodRepository day_FoodRepository;


    @Autowired
    private DayRepository dayRepository;


    @Autowired
    private FoodRepository foodRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewDay_Food(@RequestBody DayFood dayFood) {

        day_FoodRepository.save(dayFood);
        LOG.info("Add new day-food");
        return "Day Saved";

    }

    @PostMapping(path = "/addByDateStringAndFoodName")
    public @ResponseBody
    String addNewDay_Food2(@RequestParam String dateString, @RequestParam String nameFood) throws ParseException {

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(df.parse(dateString));
        Day day = dayRepository.findDayByDate(cal);

        Food food = foodRepository.findFoodByFoodname(nameFood);

        DayFood day_food = new DayFood();
        day_food.setDayId(day.getId());
        day_food.setFoodId(food.getId());
        day_FoodRepository.save(day_food);

        LOG.info("Add new day-food by dateString and food name");

        return "Day_Food Saved";

    }

    @PostMapping(path = "/allFoodFromThisDay")
    public @ResponseBody
    List<Food> getAllFoodFromThisDay(@RequestParam String dateString) throws ParseException {
        // This returns a JSON or XML with the users
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(df.parse(dateString));
        Day day = dayRepository.findDayByDate(cal);

        List<DayFood> listDayFood = day_FoodRepository.findAllByDayId(day.getId());
        List<Food> foodList = new ArrayList<>();

        for (DayFood dayFood : listDayFood) {
            Food food = foodRepository.findFoodById(dayFood.getFoodId());
            Food foodFromDay = foodRepository.findFoodByFoodname(food.getFoodname());
            foodList.add(foodFromDay);
        }
        LOG.info("Get all food from this day");
        return foodList;
    }

    @PostMapping(path = "/searchDayFood")
    public @ResponseBody
    DayFood getDayFood(@RequestParam String dateString, @RequestParam String foodname) throws ParseException {
        // This returns a JSON or XML with the users
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(df.parse(dateString));
        Day day = dayRepository.findDayByDate(cal);

        Food food = foodRepository.findFoodByFoodname(foodname);
        LOG.info("Get day-food by dateString and food name");

        return day_FoodRepository.findDayFoodByDayIdAndFoodId(day.getId(), food.getId());
    }

    @PostMapping(path = "/delete")
    public @ResponseBody
    String deleteDayFood(@RequestParam String dateString, @RequestParam String foodName) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(df.parse(dateString));
        Day day = dayRepository.findDayByDate(cal);

        Food food = foodRepository.findFoodByFoodname(foodName);

        DayFood dayFood = day_FoodRepository.findDayFoodByDayIdAndFoodId(day.getId(), food.getId());

        day_FoodRepository.delete(dayFood);

        LOG.info("Delete a day-food");

        return "Deleted dayFood";

    }

    @GetMapping(path = "/all")
    public @ResponseBody
    List<DayFood> getAllDayFoods() {
        // This returns a JSON or XML with the users

        LOG.info("Get all dayFood");
        return day_FoodRepository.findAll();

    }

    @GetMapping(path = "/allDayFoodByIdDate")
    public @ResponseBody
    List<DayFood> getallDayFoodByIdDate(long idDate) {
        // This returns a JSON or XML with the users

        LOG.info("Get all allDayFoodByIdDate");
        return day_FoodRepository.findAllByDayId(idDate);

    }
}
