package com.example.healthcaremonitoringbackend.entity;

import com.example.healthcaremonitoringbackend.boundary.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
//@Table(name = "T_FOOD")
public class Food {

    @JsonIgnore
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "FOODNAME")
    private String foodname;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "CARBOHYDRATES")
    private double carbohydrates;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "PROTEINS")
    private double proteins;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "FATS")
    private double fats;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "CATEGORY")
    private String category;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "food_day", joinColumns = @JoinColumn(name = "food_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "day_id", referencedColumnName = "id"))
    private List<Day> days;

    public void addDayIndays(Day day)
    {
        this.days.add(day);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    public Food()
    {

    }
    public Food(String foodname, double carbohydrates, double proteins, double fats, String category) {
        this.foodname = foodname;
        this.carbohydrates = carbohydrates;
        this.proteins = proteins;
        this.fats = fats;
        this.category = category;
    }
}
