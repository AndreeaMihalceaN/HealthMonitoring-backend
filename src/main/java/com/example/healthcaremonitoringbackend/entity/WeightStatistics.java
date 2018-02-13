package com.example.healthcaremonitoringbackend.entity;

import com.example.healthcaremonitoringbackend.boundary.Views;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class WeightStatistics {
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
    @Column(name = "currentWeight")
    private double currentWeight;

    public WeightStatistics(Long userId, Long dayId, double currentWeight) {
        this.userId = userId;
        this.dayId = dayId;
        this.currentWeight = currentWeight;
    }

    public WeightStatistics()
    {

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

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public Long getDayId() {
        return dayId;
    }

    public void setDayId(Long dayId) {
        this.dayId = dayId;
    }
}
