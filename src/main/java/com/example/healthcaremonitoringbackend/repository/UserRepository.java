package com.example.healthcaremonitoringbackend.repository;


import com.example.healthcaremonitoringbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsernameAndPassword(String username, String password);
    User findByUsernameAndPassword(String username, String password);
    User findUserByUsername(String username);
    //User findUserByIdAnd(int id);


}
