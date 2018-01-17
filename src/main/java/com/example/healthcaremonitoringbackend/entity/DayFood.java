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

    //@JsonIgnore
    @JsonView(Views.Public.class)
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "DAYID")
    private Long dayId;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "FOODID")
    private Long foodId;

    public DayFood(Long dayId, Long foodId) {
        this.dayId = dayId;
        this.foodId = foodId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDayId() {
        return dayId;
    }

    public void setDayId(Long dayId) {
        this.dayId = dayId;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public DayFood() {

    }
}