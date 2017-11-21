package com.example.healthcaremonitoringbackend.boundary;

import com.example.healthcaremonitoringbackend.entity.Day;
import com.example.healthcaremonitoringbackend.entity.Food;
import com.example.healthcaremonitoringbackend.entity.User;
import com.example.healthcaremonitoringbackend.repository.DayRepository;
import com.example.healthcaremonitoringbackend.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping(path = "/day")

public class DayController {

    @Autowired
    private DayRepository dayRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewDay(@RequestBody Day day) {

        dayRepository.save(day);
        return "Day Saved";

    }

    @PostMapping(path = "/addDateString")
    public @ResponseBody
    String addNewDay(@RequestParam String dateString) throws ParseException {

        Day day = new Day();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal  = Calendar.getInstance();
        cal.setTime(df.parse(dateString));
        day.setDate(cal);
        dayRepository.save(day);

        return "Day Saved";

    }

    @PostMapping(path = "/searchDay")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    Day getDay(@RequestBody Day day) {
        return dayRepository.findDayByDate(day.getDate());
    }

    @PostMapping(path = "/searchDayString")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    Day getDay(@RequestParam String dateString) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal  = Calendar.getInstance();
        cal.setTime(df.parse(dateString));
        return dayRepository.findDayByDate(cal);
    }

}
