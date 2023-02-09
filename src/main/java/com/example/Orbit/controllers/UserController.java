package com.example.Orbit.controllers;

import com.example.Orbit.models.User;
import com.example.Orbit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping (value = "/users")

public class UserController {

    @Autowired
    UserService userService;

    @GetMapping (value ="/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);

    }


    @PatchMapping (value = "/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id){
        return new ResponseEntity<>(userService.updateUser(user, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping (value="/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity("You have successfully deleted this user", HttpStatus.OK);
    }

}
