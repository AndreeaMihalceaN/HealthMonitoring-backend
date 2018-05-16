package com.example.healthcaremonitoringbackend.boundary;

import com.example.healthcaremonitoringbackend.entity.Day;
import com.example.healthcaremonitoringbackend.entity.Food;
import com.example.healthcaremonitoringbackend.entity.User;
import com.example.healthcaremonitoringbackend.repository.DayRepository;
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
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping(path = "/day")

public class DayController {
    public static final Logger LOG = LoggerFactory.getLogger(DayController.class);

    @Autowired
    private DayRepository dayRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewDay(@RequestBody Day day) {

        dayRepository.save(day);
        LOG.info("Add new day");
        return "Day Saved";

    }

    @PostMapping(path = "/addDateString")
    public @ResponseBody
    String addNewDay(@RequestParam String dateString) throws ParseException {

        Day day = new Day();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(df.parse(dateString));
        day.setDate(cal);
        dayRepository.save(day);

        LOG.info("Add new day by dateString");
        return "Day Saved";

    }

    @PostMapping(path = "/searchDay")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    Day getDay(@RequestBody Day day) {
        LOG.info("Get a day");
        return dayRepository.findDayByDate(day.getDate());
    }

    @PostMapping(path = "/searchDayString")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    Day getDay(@RequestParam String dateString) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(df.parse(dateString));
        LOG.info("Get day by dateString");
        return dayRepository.findDayByDate(cal);
    }

    @PostMapping(path = "/searchDayById")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    Day getDay(@RequestParam Long id) throws ParseException {
        LOG.info("Get day by id");
        return dayRepository.findDayById(id);
    }


    @GetMapping(path = "/all")
    public @ResponseBody
    List<Day> getAllFoods() {
        // This returns a JSON or XML with the users

        LOG.info("Get all days");
        return dayRepository.findAll();

    }
    
}
