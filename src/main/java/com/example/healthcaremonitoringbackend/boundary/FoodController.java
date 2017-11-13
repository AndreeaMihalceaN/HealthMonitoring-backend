package com.example.healthcaremonitoringbackend.boundary;

import com.example.healthcaremonitoringbackend.entity.Food;
import com.example.healthcaremonitoringbackend.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    String addNewFood2(@RequestParam String food_name, @RequestParam double carbohydrates, @RequestParam double proteins, @RequestParam double fats, @RequestParam String category) {

        Food food = new Food();
        food.setFood_name(food_name);
        food.setCarbohydrates(carbohydrates);
        food.setProteins(proteins);
        food.setFats(fats);
        food.setCategory(category);

        foodRepository.save(food);
        return "Food Saved";

    }

//    @PostMapping(path = "/searchfood")
//    public @ResponseBody
//        //@RequestParam(name = "user_name") String username, @RequestParam String password
//    Food getFood(@RequestBody Food food) {
//        return foodRepository.findFoodByFood_nameAndCarbohydratesAndProteinsAndFatsAndCategory(food.getFood_name(), food.getCarbohydrates(), food.getProteins(), food.getFats(), food.getCategory());
//    }
}
