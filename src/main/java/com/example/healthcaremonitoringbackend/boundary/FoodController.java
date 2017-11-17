package com.example.healthcaremonitoringbackend.boundary;

import com.example.healthcaremonitoringbackend.entity.Food;
import com.example.healthcaremonitoringbackend.entity.User;
import com.example.healthcaremonitoringbackend.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/food")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @PostMapping(path = "/adaugare")
    public @ResponseBody
    String addNewFood(@RequestBody Food food) {

        foodRepository.save(food);
        return "Food Saved";

    }

    @PostMapping(path = "/addd")
    public @ResponseBody
    String addNewFood2(@RequestParam String foodname, @RequestParam double carbohydrates, @RequestParam double proteins, @RequestParam double fats, @RequestParam String category) {

        Food food = new Food();
        food.setFoodname(foodname);
        food.setCarbohydrates(carbohydrates);
        food.setProteins(proteins);
        food.setFats(fats);
        food.setCategory(category);

        foodRepository.save(food);
        return "Food Saved";

    }

    @PostMapping(path = "/searchfood")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    Food getFood(@RequestBody Food food) {
        return foodRepository.findFoodByFoodname(food.getFoodname());//foodRepository.findFoodById(food.getId());//foodRepository.findFoodByFood_name(food.getFood_name()); //foodRepository.findFoodByFood_nameAndCarbohydratesAndProteinsAndFatsAndCategory(food.getFood_name(), food.getCarbohydrates(), food.getProteins(), food.getFats(), food.getCategory());
    }

    @PostMapping(path = "/searchfood2")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    Food getFood(@RequestParam String foodname) {
        return foodRepository.findFoodByFoodname(foodname);//foodRepository.findFoodById(food.getId());//foodRepository.findFoodByFood_name(food.getFood_name()); //foodRepository.findFoodByFood_nameAndCarbohydratesAndProteinsAndFatsAndCategory(food.getFood_name(), food.getCarbohydrates(), food.getProteins(), food.getFats(), food.getCategory());
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    List<Food> getAllFoods() {
        // This returns a JSON or XML with the users
        return foodRepository.findAll();
    }
}
