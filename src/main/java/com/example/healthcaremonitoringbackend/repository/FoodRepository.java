package com.example.healthcaremonitoringbackend.repository;


import com.example.healthcaremonitoringbackend.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    //Food findFoodByFood_nameAndCarbohydratesAndProteinsAndFatsAndCategory(String food_name, double carbohydrates, double proteins, double fats, String category);

    Food findFoodByFoodname(String foodname);
    Food findFoodById(Long id);

}
