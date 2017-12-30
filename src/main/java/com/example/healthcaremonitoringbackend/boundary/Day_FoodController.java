package com.example.healthcaremonitoringbackend.boundary;

import com.example.healthcaremonitoringbackend.entity.*;
import com.example.healthcaremonitoringbackend.repository.DayRepository;
import com.example.healthcaremonitoringbackend.repository.Day_FoodRepository;
import com.example.healthcaremonitoringbackend.repository.FoodRepository;
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
        return "Day Saved";

    }

    @PostMapping(path = "/addByDateStringAndFoodName")
    public @ResponseBody
    String addNewDay_Food2(@RequestParam String dateString,@RequestParam String nameFood) throws ParseException {

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(df.parse(dateString));
        Day day =dayRepository.findDayByDate(cal);

        Food food = foodRepository.findFoodByFoodname(nameFood);

        DayFood day_food = new DayFood();
        day_food.setDay(day);
        day_food.setFood(food);
        day_FoodRepository.save(day_food);

        return "Day_Food Saved";

    }

    @PostMapping(path = "/allFoodFromThisDay")
    public @ResponseBody
    List<Food> getAllFoodFromThisDay(@RequestParam String dateString) throws ParseException {
        // This returns a JSON or XML with the users
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(df.parse(dateString));
        Day day =dayRepository.findDayByDate(cal);

        List<DayFood>listDayFood= day_FoodRepository.findAllByDay(day);
        List<Food>foodList=new ArrayList<>();

        for(DayFood dayFood: listDayFood)
        {
            Food foodFromDay=foodRepository.findFoodByFoodname(dayFood.getFood().getFoodname());
            foodList.add(foodFromDay);
        }
        return foodList;
    }

    @PostMapping(path = "/searchDayFood")
    public @ResponseBody
    DayFood getDayFood(@RequestParam String dateString, @RequestParam String foodname) throws ParseException {
        // This returns a JSON or XML with the users
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(df.parse(dateString));
        Day day =dayRepository.findDayByDate(cal);

        Food food= foodRepository.findFoodByFoodname(foodname);

        return day_FoodRepository.findDayFoodByDayAndFood(day, food);
    }

    //Don't work because I have foreign key
//    @PostMapping(path = "/delete")
//    public @ResponseBody
//    String deleteDayFood(@RequestParam Long idDayFood){
//        DayFood dayFood= day_FoodRepository.findDayFoodById(idDayFood);
//        day_FoodRepository.delete(dayFood);
//
//        return "DayFood deleted";
//
//    }
}
