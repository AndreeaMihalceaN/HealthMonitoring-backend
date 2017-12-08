package com.example.healthcaremonitoringbackend.repository;

import com.example.healthcaremonitoringbackend.entity.DayFood;
import com.example.healthcaremonitoringbackend.entity.User;
import com.example.healthcaremonitoringbackend.entity.UserDiary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDiaryRepository  extends JpaRepository<UserDiary, Long> {
    UserDiary findUserDiaryByDayFoodAndUser(DayFood dayFood, User user);
}
