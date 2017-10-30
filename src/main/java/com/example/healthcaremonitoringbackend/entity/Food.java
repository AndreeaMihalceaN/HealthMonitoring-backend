//package com.example.healthcaremonitoringbackend.entity;
//
//import com.example.healthcaremonitoringbackend.boundary.Views;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonView;
//import org.springframework.data.annotation.Id;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
//@Entity
//@Table(name = "T_FOOD")
//public class Food {
//
//    @JsonIgnore
//    @Id
//    @Column(name = "ID")
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @JsonView(Views.Public.class)
//    @NotNull
//    @Column(name = "FOOD_NAME")
//    private String food_name;
//
//    @JsonIgnore
//    @Id
//    @Column(name = "CARBOHYDRATES")
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private double carbohydrates;
//
//    @JsonView(Views.Public.class)
//    @NotNull
//    @Column(name = "PROTEINS")
//    private double proteins;
//
//    @JsonView(Views.Public.class)
//    @NotNull
//    @Column(name = "FATS")
//    private double fats;
//
//    @JsonView(Views.Public.class)
//    @NotNull
//    @Column(name = "CATEGORY")
//    private double category;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFood_name() {
//        return food_name;
//    }
//
//    public void setFood_name(String food_name) {
//        this.food_name = food_name;
//    }
//
//    public double getCarbohydrates() {
//        return carbohydrates;
//    }
//
//    public void setCarbohydrates(double carbohydrates) {
//        this.carbohydrates = carbohydrates;
//    }
//
//    public double getProteins() {
//        return proteins;
//    }
//
//    public void setProteins(double proteins) {
//        this.proteins = proteins;
//    }
//
//    public double getFats() {
//        return fats;
//    }
//
//    public void setFats(double fats) {
//        this.fats = fats;
//    }
//
//    public double getCategory() {
//        return category;
//    }
//
//    public void setCategory(double category) {
//        this.category = category;
//    }
//}
