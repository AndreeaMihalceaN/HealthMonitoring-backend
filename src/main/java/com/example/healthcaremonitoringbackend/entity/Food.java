package com.example.healthcaremonitoringbackend.entity;

import com.example.healthcaremonitoringbackend.boundary.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @Column(name = "FOOD_NAME")
    private String food_name;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
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

    public Food()
    {

    }
    public Food(String food_name, double carbohydrates, double proteins, double fats, String category) {
        this.food_name = food_name;
        this.carbohydrates = carbohydrates;
        this.proteins = proteins;
        this.fats = fats;
        this.category = category;
    }
}
