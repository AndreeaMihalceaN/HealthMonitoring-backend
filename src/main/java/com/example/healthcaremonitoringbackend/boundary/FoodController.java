package com.example.healthcaremonitoringbackend.boundary;

import com.example.healthcaremonitoringbackend.entity.Food;
import com.example.healthcaremonitoringbackend.entity.User;
import com.example.healthcaremonitoringbackend.entity.UserDiary;
import com.example.healthcaremonitoringbackend.repository.FoodRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/food")
public class FoodController {
    public static final Logger LOG = LoggerFactory.getLogger(FoodController.class);

    @Autowired
    private FoodRepository foodRepository;

    @PostMapping(path = "/adaugare")
    public @ResponseBody
    String addNewFood(@RequestBody Food food) {

        foodRepository.save(food);
        LOG.info("Add a new food");
        LOG.debug("Was saved a new user");
        return "Food Saved";

    }


    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewFood(@RequestParam String foodname, @RequestParam double carbohydrates, @RequestParam double proteins, @RequestParam double fats, @RequestParam String category,@RequestParam String pictureString, @RequestParam int stars, @RequestParam String url) {

        Food food = new Food();
        food.setFoodname(foodname);
        food.setCarbohydrates(carbohydrates);
        food.setProteins(proteins);
        food.setFats(fats);
        food.setCategory(category);
        food.setPictureString(pictureString);
        food.setStars(stars);
        food.setUrl(url);

        foodRepository.save(food);
        LOG.info("Add a new food by foodname, carbohydrates, proteins, fats, category, pictureString, stars, url");
        LOG.debug("Was saved a new user");
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

    @PostMapping(path = "/searchFoodById")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    Food getFoodById(@RequestParam Long id) {
        LOG.debug("Serch food by id");
        return foodRepository.findFoodById(id);//foodRepository.findFoodById(food.getId());//foodRepository.findFoodByFood_name(food.getFood_name()); //foodRepository.findFoodByFood_nameAndCarbohydratesAndProteinsAndFatsAndCategory(food.getFood_name(), food.getCarbohydrates(), food.getProteins(), food.getFats(), food.getCategory());
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    List<Food> getAllFoods() {
        // This returns a JSON or XML with the users
        LOG.debug("Get all food");
        return foodRepository.findAll();

    }

    //For unit test

    @PostMapping(path = "/delete")
    public @ResponseBody
    String deleteFood(@RequestParam Long id) {
        Food food = foodRepository.findFoodById(id);
        foodRepository.delete(food);
        LOG.info("Food deleted");
        return "Food deleted";

    }
}
