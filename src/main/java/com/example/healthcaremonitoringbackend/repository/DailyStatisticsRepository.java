package com.example.healthcaremonitoringbackend.repository;

import com.example.healthcaremonitoringbackend.boundary.DailyStatisticsController;
import com.example.healthcaremonitoringbackend.entity.DailyStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyStatisticsRepository extends JpaRepository<DailyStatistics, Long> {
    DailyStatistics findDailyStatisticsByDayIdAndUserId(Long dayId, Long userId);
}
