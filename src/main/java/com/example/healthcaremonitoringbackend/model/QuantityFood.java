package com.example.healthcaremonitoringbackend.model;

import com.example.healthcaremonitoringbackend.entity.Food;

public class QuantityFood {
    private Food food;
    private double quantity;

    public QuantityFood(Food food, double quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
