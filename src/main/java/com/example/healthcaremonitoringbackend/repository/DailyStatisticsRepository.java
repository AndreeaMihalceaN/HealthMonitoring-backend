package com.example.healthcaremonitoringbackend.repository;

import com.example.healthcaremonitoringbackend.boundary.DailyStatisticsController;
import com.example.healthcaremonitoringbackend.entity.DailyStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyStatisticsRepository extends JpaRepository<DailyStatistics, Long> {
    DailyStatistics findDailyStatisticsByDayIdAndUserId(Long dayId, Long userId);
    List<DailyStatistics> findDailyStatisticsByUserId(Long userId);
}
