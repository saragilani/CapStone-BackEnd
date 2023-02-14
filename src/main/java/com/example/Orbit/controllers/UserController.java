package com.example.Orbit.controllers;

import com.example.Orbit.models.Caree;
import com.example.Orbit.models.User;
import com.example.Orbit.services.LoginDTO;
import com.example.Orbit.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value = "/users")

public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping (value ="/{id}")
    public ResponseEntity<Optional<User>> getUserById(@RequestParam Long id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);

    }

    @GetMapping (value="/emailAddress")
    public ResponseEntity<Optional<User>> findUserByEmailAddress(@RequestBody String emailAddress){
        System.out.println(emailAddress);
        ResponseEntity checkEmail = new ResponseEntity<>(userService.findUserByEmailAddress(emailAddress), HttpStatus.OK);
        System.out.println(checkEmail);
        return checkEmail;

    }

    @PostMapping (value = "/login")
    public ResponseEntity<User> checkLogin(@RequestBody LoginDTO loginDTO){
        String password = loginDTO.getUserPassword();
        String emailAddress = loginDTO.getUserEmailAddress();
        User loginData = userService.checkLogin(password, emailAddress);
        return new ResponseEntity<>(loginData, HttpStatus.OK);
    }

    // DTO between service and controller
    //login DTO
    // userService.checkLogin(email,password)
    //find user
    //check if password matches
    //user.getPassword()
    // error message if it doesn't match


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
