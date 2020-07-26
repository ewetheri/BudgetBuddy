package com.wetherill.budgetbuddy.thin.rest;

import com.wetherill.budgetbuddy.core.login.User;
import com.wetherill.budgetbuddy.core.login.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    // Might end up needed an @CrossOrigin(origins = "http://localhost:4200") annotation on this class, so Angular plays nice.

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<String> getUsernames() {
        List<String> usernames = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            usernames.add(user.getUsername());
        }
        return usernames;
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
}
