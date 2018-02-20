package com.example.healthcaremonitoringbackend.boundary;

import com.example.healthcaremonitoringbackend.entity.DailyStatistics;
import com.example.healthcaremonitoringbackend.entity.Food;
import com.example.healthcaremonitoringbackend.entity.UserDiary;
import com.example.healthcaremonitoringbackend.repository.DailyStatisticsRepository;
import com.example.healthcaremonitoringbackend.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(path = "/dailyStatistics")
public class DailyStatisticsController {

    @Autowired
    private DailyStatisticsRepository dailyStatisticsRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewDailyStatistics(@RequestBody DailyStatistics dailyStatistics) {

        dailyStatisticsRepository.save(dailyStatistics);
        return "DailyStatistics Saved";

    }

    @PostMapping(path = "/add2")
    public @ResponseBody
    String addNewFood(@RequestParam Long dayId, @RequestParam double totalCalories, @RequestParam Long userId, @RequestParam double steps) {

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

        dailyStatisticsRepository.save(oldDailyStatistics);
        return "Updated quantity for an existing DailyStatistics";

    }

    @PostMapping(path = "/searchDailyStatistics")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    DailyStatistics getDailyStatistics(@RequestParam Long userId, @RequestParam Long dayId) {
        return dailyStatisticsRepository.findDailyStatisticsByDayIdAndUserId(dayId, userId);
    }

    @PostMapping(path = "/searchDailyStatisticsByUserId")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    List<DailyStatistics> getDailyStatisticsByUserId(@RequestParam Long userId) {
        return dailyStatisticsRepository.findDailyStatisticsByUserId(userId);
    }


}
