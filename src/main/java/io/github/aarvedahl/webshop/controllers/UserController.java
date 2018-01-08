package io.github.aarvedahl.webshop.controllers;

import io.github.aarvedahl.webshop.jpa.User;
import io.github.aarvedahl.webshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @PostMapping
    public void addUser(@RequestBody User user) {
        userRepository.save(user);
    }

}
