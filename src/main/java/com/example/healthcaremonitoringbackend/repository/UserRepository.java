package com.example.healthcaremonitoringbackend.repository;


import com.example.healthcaremonitoringbackend.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);

}
