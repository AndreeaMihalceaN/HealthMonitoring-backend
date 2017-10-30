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
    public UserInfo getUser(User credentials) {
        User user = userRepository.findByUsernameAndPassword(credentials.getUsername(), credentials.getPassword());
        if (user != null) {
            UserInfo response = new UserInfo();
            response.setFirstName(user.getFirstName());
            response.setLastName(user.getLastName());
            response.setUsername(user.getUsername());
            return response;
        }
        else return new UserInfo();
//        } else {
//            throw new ParkingException("Failed login!");
//        }
    }

    public static class UserInfo{

        private String username;
        private String firstName;
        private String lastName;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
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
    }


}
