package com.example.healthcaremonitoringbackend.entity;


import com.example.healthcaremonitoringbackend.boundary.Views;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Calendar;
import java.util.Set;

@Entity
public class Day {

    //@JsonIgnore
    @JsonView(Views.Public.class)
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(Views.Public.class)
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "EET")
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Calendar date;

    //@OneToMany(mappedBy = "day", cascade = CascadeType.ALL)
//    private Set<DayFood> listDayFoods;

//    public Set<DayFood> getListDayFoods() {
//        return listDayFoods;
//    }


//    public void setListDayFoods(Set<DayFood> listDayFoods) {
//        this.listDayFoods = listDayFoods;
//    }

//    @ManyToMany(mappedBy = "days")
//    private List<Food> foods;

    public Day() {

        //this.foods= new ArrayList<Food>();
    }

    public Day(Calendar date) {
        this.date = date;
        //this.foods= new ArrayList<Food>();
    }

//    public void addFoodInFoods(Food food)
//    {
//        this.foods.add(food);
//    }

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

//    public List<Food> getFoods() {
//        return foods;
//    }

//    public void setFoods(List<Food> foods) {
//        this.foods = foods;
//    }

//    @Override
//    public String toString() {
//        return "Day{" +
//                "id=" + id +
//                ", date=" + date +
//                ", foods=" + foods +
//                '}';
//    }
}
