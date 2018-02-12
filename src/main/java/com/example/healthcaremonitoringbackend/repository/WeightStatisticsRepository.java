package com.example.healthcaremonitoringbackend.repository;

import com.example.healthcaremonitoringbackend.entity.WeightStatistics;
import com.example.healthcaremonitoringbackend.entity.DailyStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightStatisticsRepository extends JpaRepository<WeightStatistics, Long>  {
}
