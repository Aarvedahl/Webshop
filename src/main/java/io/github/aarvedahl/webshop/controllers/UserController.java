package io.github.aarvedahl.webshop.controllers;

import io.github.aarvedahl.webshop.dto.Userdto;
import io.github.aarvedahl.webshop.jpa.Purchase;
import io.github.aarvedahl.webshop.jpa.Users;
import io.github.aarvedahl.webshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    List<Users> users;

    @PostMapping
    public void addUser(@RequestBody Userdto userdto) {
        Users user = new Users(userdto.getUserid(), userdto.getUsername(), userdto.getRole(), userdto.getEmail());
        userRepository.save(user);
    }

    @PatchMapping
    public void editUser(@RequestBody Userdto userdto) {
        Users user = new Users(userdto.getUserid(), userdto.getUsername(), userdto.getRole(), userdto.getEmail());
        userRepository.save(user);
    }

    @GetMapping
    public List<Users> getUsers() {
        users = userRepository.findAll();
        return users;
    }

    @RequestMapping(value = "/{userid}", method = RequestMethod.GET)
    public Users getOneUser(@PathVariable("userid") int userid) {
        Users users = userRepository.findByUserid(userid);
        return users;
    }

    @DeleteMapping
    public void removeUser(@RequestBody Userdto userdto) {
        Users user = new Users(userdto.getUserid(), userdto.getUsername(), userdto.getRole(), userdto.getEmail());
        userRepository.delete(user);
    }

}
