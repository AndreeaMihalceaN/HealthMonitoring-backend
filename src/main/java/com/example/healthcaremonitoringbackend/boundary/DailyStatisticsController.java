package com.example.healthcaremonitoringbackend.boundary;

import com.example.healthcaremonitoringbackend.entity.DailyStatistics;
import com.example.healthcaremonitoringbackend.entity.Day;
import com.example.healthcaremonitoringbackend.entity.Food;
import com.example.healthcaremonitoringbackend.entity.UserDiary;
import com.example.healthcaremonitoringbackend.repository.DailyStatisticsRepository;
import com.example.healthcaremonitoringbackend.repository.DayRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping(path = "/dailyStatistics")
public class DailyStatisticsController {

    public static final Logger LOG = LoggerFactory.getLogger(DailyStatisticsController.class);

    @Autowired
    private DailyStatisticsRepository dailyStatisticsRepository;

    @Autowired
    private DayRepository dayRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewDailyStatistics(@RequestBody DailyStatistics dailyStatistics) {

        LOG.info("Add new daily statistics");
        dailyStatisticsRepository.save(dailyStatistics);
        return "DailyStatistics Saved";

    }

    @PostMapping(path = "/delete")
    public @ResponseBody
    String deleteDailyStatistics() {


        dailyStatisticsRepository.deleteAll();
        return "Deleted all";

    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<DailyStatistics> getAllDailyStatistics() {
        // This returns a JSON or XML with the users
        LOG.info("Get all dailyStatistics");
        LOG.debug("Get all dailyStatistics");
        return dailyStatisticsRepository.findAll();
    }

    @PostMapping(path = "/add2")
    public @ResponseBody
    String addDailyStatisticsWithoutId(@RequestParam Long dayId, @RequestParam double totalCalories, @RequestParam Long userId, @RequestParam double steps) {

        LOG.info("Add new daily statistics");
        DailyStatistics dailyStatistics = new DailyStatistics();
        dailyStatistics.setDayId(dayId);
        dailyStatistics.setTotalCalories(totalCalories);
        dailyStatistics.setUserId(userId);
        dailyStatistics.setSteps(steps);

        dailyStatisticsRepository.save(dailyStatistics);
        return "DailyStatistics object Saved";

    }


    @PostMapping(path = "/updateDailyStatistics")
    public @ResponseBody
    String updateUserDiaryQuantity(@RequestParam double quantity, @RequestParam Long userId, @RequestParam Long dayId) {

        DailyStatistics oldDailyStatistics = dailyStatisticsRepository.findDailyStatisticsByDayIdAndUserId(dayId, userId);
        oldDailyStatistics.setTotalCalories(quantity);

        LOG.info("Update daily statistics");
        dailyStatisticsRepository.save(oldDailyStatistics);
        return "Updated quantity for an existing DailyStatistics";

    }

    @PostMapping(path = "/searchDailyStatistics")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    DailyStatistics getDailyStatistics(@RequestParam Long userId, @RequestParam Long dayId) {
        LOG.info("Get daily statistics by userId and dayId");
        return dailyStatisticsRepository.findDailyStatisticsByDayIdAndUserId(dayId, userId);
    }

    @PostMapping(path = "/searchDailyStatisticsByUserId")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    List<DailyStatistics> getDailyStatisticsByUserId(@RequestParam Long userId) {
        LOG.info("Gey daily statistics by userId");
        return dailyStatisticsRepository.findDailyStatisticsByUserId(userId);
    }


    @PostMapping(path = "/searchDailyStatisticsByUserAndDate")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    DailyStatistics getDailyStatistics(@RequestParam Long userId, @RequestParam String dateString) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(df.parse(dateString));

        Day day = dayRepository.findDayByDate(cal);

        LOG.info("Get daily statistics by userId and dateString");
        return dailyStatisticsRepository.findDailyStatisticsByDayIdAndUserId(day.getId(), userId);
    }

    @PostMapping(path = "/updateDailyStatisticsSteps")
    public @ResponseBody
    String updateUserDiarySteps(@RequestParam double steps, @RequestParam Long userId, @RequestParam Long dayId) {

        DailyStatistics oldDailyStatistics = dailyStatisticsRepository.findDailyStatisticsByDayIdAndUserId(dayId, userId);
        oldDailyStatistics.setSteps(steps);

        LOG.info("Update steps for daily statistics");
        dailyStatisticsRepository.save(oldDailyStatistics);
        return "Updated steps for an existing DailyStatistics";

    }

}
