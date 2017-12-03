package com.example.healthcaremonitoringbackend.entity;

import com.example.healthcaremonitoringbackend.boundary.Views;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Calendar;

@Entity
public class DayFood {

    @JsonIgnore
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "day_id")
    private Day day;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public DayFood(Day day, Food food) {
        this.day = day;
        this.food = food;
    }

    public DayFood() {

    }
}
