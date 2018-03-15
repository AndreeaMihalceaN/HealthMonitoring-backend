package com.example.healthcaremonitoringbackend.entity;

import com.example.healthcaremonitoringbackend.boundary.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
//@Table(name = "T_USER")
public class User {

    //@JsonIgnore
    @JsonView(Views.Public.class)
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "USERNAME")
    private String username;

    @JsonView(Views.Internal.class)
    @NotNull
    @Column(name = "PASSWORD")
    private String password;

    @JsonView(Views.Public.class)
    @Column(name = "FIRST_NAME")
    private String firstName;

    @JsonView(Views.Public.class)
    @Column(name = "LAST_NAME")
    private String lastName;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "HEIGHT")
    private int height;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "WEIGHT")
    private int weight;

    @JsonView(Views.Public.class)
    @NotNull
    @Size(max = 1)
    @Column(name = "GENDER")
    private String gender;

    @JsonView(Views.Public.class)
    @NotNull
    //@Column(name = "null", nullable=false)
    @Column(name = "EMAIL")
    private String email;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "CONTACTNO")
    private String contactNo;


    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "AGE")
    private int age;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "STEPSOBJECTIVE")
    private double stepsObjective;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getStepsObjective() {
        return stepsObjective;
    }

    public void setStepsObjective(double stepsObjective) {
        this.stepsObjective = stepsObjective;
    }
}