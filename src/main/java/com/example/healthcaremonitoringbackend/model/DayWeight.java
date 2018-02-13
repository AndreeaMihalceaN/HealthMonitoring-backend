package com.example.healthcaremonitoringbackend.model;

import com.example.healthcaremonitoringbackend.entity.Day;

public class DayWeight {
    private Day day;
    private double currentWeight;

    public DayWeight(Day day, double currentWeight) {
        this.day = day;
        this.currentWeight = currentWeight;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }
}
