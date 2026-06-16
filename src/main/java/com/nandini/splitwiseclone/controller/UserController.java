package com.nandini.splitwiseclone.controller;

import com.nandini.splitwiseclone.model.User;
import com.nandini.splitwiseclone.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/createuser")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/getusers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
            userService.deleteUserById(id);
            return ResponseEntity.ok("User Deleted Successfully with id: " + id);
    }

    @PutMapping("/user/id/{id}")
    public User updatedUser(@PathVariable Long id, @RequestBody User updatedUser){
        return userService.updateUser(id, updatedUser);
    }
}
