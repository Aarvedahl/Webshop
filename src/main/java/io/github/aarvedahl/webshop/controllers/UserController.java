package io.github.aarvedahl.webshop.controllers;

import io.github.aarvedahl.webshop.jpa.Users;
import io.github.aarvedahl.webshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    List<Users> users;

    @PostMapping
    public void addUser(@RequestBody Users users) {
        userRepository.save(users);
    }

    @GetMapping
    public List<Users> getUsers() {
        users = userRepository.findAll();
        return users;
    }

}
