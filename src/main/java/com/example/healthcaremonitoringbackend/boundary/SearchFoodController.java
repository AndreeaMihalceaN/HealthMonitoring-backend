//package com.example.healthcaremonitoringbackend.boundary;
//
//
//import com.example.healthcaremonitoringbackend.control.LoginService;
//import com.example.healthcaremonitoringbackend.entity.Food;
//import com.example.healthcaremonitoringbackend.entity.User;
//import com.example.healthcaremonitoringbackend.repository.FoodRepository;
//import com.example.healthcaremonitoringbackend.repository.UserRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class SearchFoodController {
//
//    @Autowired
//    private FoodRepository foodRepository;// = new UserRepository();
//
//    @PostMapping(path = "/searchFood")
//    public @ResponseBody
//        //@RequestParam(name = "user_name") String username, @RequestParam String password
//    Food getFood(@RequestBody Food food) {
//        //return foodRepository.findFoodByFood_nameAndCarbohydratesAndProteinsAndFatsAndCategory(food.getFood_name(), food.getCarbohydrates(), food.getProteins(), food.getFats(), food.getCategory());
//    return new Food();
//    }
//}
