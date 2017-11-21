package com.example.healthcaremonitoringbackend.entity;


import com.example.healthcaremonitoringbackend.boundary.Views;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

@Entity
public class Day {
    @JsonIgnore
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(Views.Public.class)
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "EET")
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Calendar date;

    @ManyToMany(mappedBy = "days")
    public List<Food> foods;

    public Day() {

    }

    public Day(Calendar date) {
        this.date = date;
    }

    public void addFoodInFoods(Food food)
    {
        this.foods.add(food);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }
}
