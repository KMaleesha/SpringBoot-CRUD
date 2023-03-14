package com.loit.demo.controller;

import com.loit.demo.domain.User;
import com.loit.demo.resource.UserResource;
import com.loit.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin
public class UserController<lastName> {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/save")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping(value = "/get-all")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping(value = "/get-by-id/{id}")
    public Optional<User> getById(@PathVariable int id){
        return userService.getById(id);
    }

    @GetMapping(value ="/get-by-firstname/{firstName}")
    public List<User> getByFirstName(@PathVariable String firstName){
        return userService.getByFirstName(firstName);
    }
    @GetMapping(value = "/get-by-lastname/{lastName}")
    public List<User> getByLastName(@PathVariable String lastName){
        return userService.getByLastName(lastName);
    }

    @PutMapping(value = "/update/{id}")
    public User updateUser(@RequestBody UserResource userResource, @PathVariable int id){
        return userService.updateUser(userResource, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }

    @GetMapping(value = "/search")
    public List<User> users(@RequestParam(value = "search", required = true) String search){
            return userService.searchByUser(search);
    }
}
