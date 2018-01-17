package com.example.healthcaremonitoringbackend.control;

import com.example.healthcaremonitoringbackend.entity.User;
import com.example.healthcaremonitoringbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateCustomizer;
import org.springframework.transaction.annotation.Transactional;

public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    //public UserInfo getUser(User credentials) {
    public User getUser(User credentials) {
        User user = userRepository.findUserByUsernameAndPassword(credentials.getUsername(), credentials.getPassword());
        if (user != null) {
            //UserInfo response = new UserInfo();
            User response = new User();
//            response.setUsername(user.getUsername());
//            response.setPassword(user.getPassword());
            response.setId(user.getId());
            response.setUsername(user.getUsername());
            response.setPassword(user.getPassword());
            response.setFirstName(user.getFirstName());
            response.setLastName(user.getLastName());
            response.setGender(user.getGender());
            response.setWeight(user.getWeight());
            response.setHeight(user.getHeight());

            return response;
        }
        //else return new UserInfo();
        else return new User();
//        } else {
//            throw new ParkingException("Failed login!");
//        }
    }

    public static class UserInfo{

        private String username;
        private String password;

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
    }


}
