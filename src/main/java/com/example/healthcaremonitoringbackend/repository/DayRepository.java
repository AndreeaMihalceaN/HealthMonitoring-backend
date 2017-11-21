package com.example.healthcaremonitoringbackend.repository;


import com.example.healthcaremonitoringbackend.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Calendar;

public interface DayRepository  extends JpaRepository<Day, Long>{

    Day findDayByDate(Calendar date);

}
