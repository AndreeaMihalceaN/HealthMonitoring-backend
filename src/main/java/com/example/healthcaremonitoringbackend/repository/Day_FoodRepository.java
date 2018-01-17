package com.example.healthcaremonitoringbackend.repository;


import com.example.healthcaremonitoringbackend.entity.Day;
import com.example.healthcaremonitoringbackend.entity.DayFood;
import com.example.healthcaremonitoringbackend.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Day_FoodRepository  extends JpaRepository<DayFood, Long> {

    List<DayFood>findAllByDayId(Long dayId);
    DayFood findDayFoodByDayIdAndFoodId(Long dayId, Long foodId);
    DayFood findDayFoodById(Long id);
}
