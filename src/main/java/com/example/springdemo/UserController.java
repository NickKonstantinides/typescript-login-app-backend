package com.example.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "http://localhost:3000",exposedHeaders = "Access-Control-Allow-Origin")
@RequestMapping(path="")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/register")
    public @ResponseBody String registerNewUser(@RequestParam String username, @RequestParam String password) {
        User newUser = new User(username, password);
        userRepository.save(newUser);
        return "Saved";
    }

    @PostMapping(path="/login")
    public @ResponseBody User loginUser(@RequestParam String username, @RequestParam String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

}