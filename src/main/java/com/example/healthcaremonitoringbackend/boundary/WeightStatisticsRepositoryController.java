package com.example.healthcaremonitoringbackend.boundary;

import com.example.healthcaremonitoringbackend.entity.Day;
import com.example.healthcaremonitoringbackend.entity.WeightStatistics;
import com.example.healthcaremonitoringbackend.model.DayWeight;
import com.example.healthcaremonitoringbackend.repository.DayRepository;
import com.example.healthcaremonitoringbackend.repository.WeightStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(path = "/weightStatistics")
public class WeightStatisticsRepositoryController {

    @Autowired
    private WeightStatisticsRepository weightStatisticsRepository;
    @Autowired
    private DayRepository dayRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewFood(@RequestParam Long userId, @RequestParam Long dayId, @RequestParam double currentWeight) {

        WeightStatistics weightStatistics = new WeightStatistics();
        weightStatistics.setUserId(userId);
        weightStatistics.setDayId(dayId);
        weightStatistics.setCurrentWeight(currentWeight);

        weightStatisticsRepository.save(weightStatistics);
        return "WeightStatistics object Saved";

    }

    @PostMapping(path = "/dayWeightForUser")
    public @ResponseBody
    Set<DayWeight> getDayWeight(@RequestParam Long userId) throws ParseException {

        List<WeightStatistics> weightStatisticsList = weightStatisticsRepository.findWeightStatisticsByUserId(userId);
        Set<DayWeight> dayWeightSet = new HashSet<>();
        for (WeightStatistics weightStatistics : weightStatisticsList) {
            Day day = dayRepository.findDayById(weightStatistics.getDayId());
            dayWeightSet.add(new DayWeight(day, weightStatistics.getCurrentWeight()));
        }
        return dayWeightSet;

    }
}
