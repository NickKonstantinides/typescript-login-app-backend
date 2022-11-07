package com.example.springdemo;

import org.springframework.data.repository.CrudRepository;
import com.example.springdemo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsernameAndPassword(String username, String password);
}