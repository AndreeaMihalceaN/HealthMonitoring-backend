package com.example.healthcaremonitoringbackend.entity;

import com.example.healthcaremonitoringbackend.boundary.Views;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class DailyStatistics {
    @JsonView(Views.Public.class)
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "USERID")
    private Long userId;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "DAYID")
    private Long dayId;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "TOTALCALORIES")
    private double totalCalories;

    public DailyStatistics(Long userId, Long dayId, double totalCalories) {
        this.userId = userId;
        this.dayId = dayId;
        this.totalCalories = totalCalories;
    }

    public DailyStatistics() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDayId() {
        return dayId;
    }

    public void setDayId(Long dayId) {
        this.dayId = dayId;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }
}
