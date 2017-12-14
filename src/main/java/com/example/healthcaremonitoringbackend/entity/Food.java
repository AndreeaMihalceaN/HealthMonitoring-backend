package com.example.healthcaremonitoringbackend.entity;

import com.example.healthcaremonitoringbackend.boundary.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "PICTURESTRING")
    private String pictureString;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "STARS")
    private int stars;



//    @ManyToMany(cascade = CascadeType.ALL)
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "food_day", joinColumns = @JoinColumn(name = "food_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "day_id", referencedColumnName = "id"))
//    private List<Day> days;

//    public void addDayIndays(Day day)
//    {
//        this.days.add(day);
//    }


//    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
//    private Set<DayFood> listDayFoods;
//
//    public Set<DayFood> getListDayFoods() {
//        return listDayFoods;
//    }
//
//    public void setListDayFoods(Set<DayFood> listDayFoods) {
//        this.listDayFoods = listDayFoods;
//    }

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

    public String getPictureString() {
        return pictureString;
    }

    public void setPictureString(String pictureString) {
        this.pictureString = pictureString;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    //    public List<Day> getDays() {
//        return days;
//    }

//    public void setDays(List<Day> days) {
//        this.days = days;
//    }

    public Food() {
        //this.days= new ArrayList<Day>();
    }

    public Food(String foodname, double carbohydrates, double proteins, double fats, String category, String pictureString) {
        this.foodname = foodname;
        this.carbohydrates = carbohydrates;
        this.proteins = proteins;
        this.fats = fats;
        this.category = category;
        this.pictureString = pictureString;
    }

    public Food(String foodname, double carbohydrates, double proteins, double fats, String category) {
        this.foodname = foodname;
        this.carbohydrates = carbohydrates;
        this.proteins = proteins;
        this.fats = fats;
        this.category = category;
        //this.days= new ArrayList<Day>();
    }

    public Food(String foodname, double carbohydrates, double proteins, double fats, String category, String pictureString, int stars) {
        this.foodname = foodname;
        this.carbohydrates = carbohydrates;
        this.proteins = proteins;
        this.fats = fats;
        this.category = category;
        this.pictureString = pictureString;
        this.stars = stars;
    }

    //
//    @Override
//    public String toString() {
//        return "Food{" +
//                "id=" + id +
//                ", foodname='" + foodname + '\'' +
//                ", carbohydrates=" + carbohydrates +
//                ", proteins=" + proteins +
//                ", fats=" + fats +
//                ", category='" + category + '\'' +
//                ", days=" + days +
//                '}';
//    }
}
