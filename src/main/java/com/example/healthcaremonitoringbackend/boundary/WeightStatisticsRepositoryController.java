package com.example.healthcaremonitoringbackend.boundary;

import com.example.healthcaremonitoringbackend.entity.WeightStatistics;
import com.example.healthcaremonitoringbackend.repository.WeightStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/weightStatistics")
public class WeightStatisticsRepositoryController {

    @Autowired
    private WeightStatisticsRepository weightStatisticsRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewFood(@RequestParam Long userId, @RequestParam double currentWeight) {

        WeightStatistics weightStatistics = new WeightStatistics();
        weightStatistics.setUserId(userId);
        weightStatistics.setCurrentWeight(currentWeight);

        weightStatisticsRepository.save(weightStatistics);
        return "WeightStatistics object Saved";

    }
}
