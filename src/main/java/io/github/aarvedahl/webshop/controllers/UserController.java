package io.github.aarvedahl.webshop.controllers;

import io.github.aarvedahl.webshop.dto.Userdto;
import io.github.aarvedahl.webshop.jpa.User_roles;
import io.github.aarvedahl.webshop.jpa.Users;
import io.github.aarvedahl.webshop.repository.UserRepository;
import io.github.aarvedahl.webshop.repository.User_rolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    User_rolesRepository userRolesRepository;

    List<Users> users;


    @PostMapping("/add")
    public void addUser(@RequestBody Userdto userdto) {
        Users user = new Users(userdto.getUsername(), userdto.getPassword(), true);
        userRepository.save(user);
        User_roles userRoles = new User_roles(userdto.getUsername(), "ROLE_USER");
        userRolesRepository.save(userRoles);
    }

    @PatchMapping
    public void editUser(@RequestBody Userdto userdto) {
        Users user = new Users(userdto.getUserid(), userdto.getUsername(), userdto.getPassword(), userdto.isEnabled());
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
        Users user = new Users(userdto.getUserid(), userdto.getUsername(), userdto.getPassword(), userdto.isEnabled());
        userRepository.delete(user);
    }

}
