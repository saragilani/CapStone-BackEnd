package com.example.Orbit.controllers;

import com.example.Orbit.models.Need;
import com.example.Orbit.repositories.NeedRepository;
import com.example.Orbit.services.NeedService;
import com.example.Orbit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/needs")
public class NeedController {

    @Autowired
    NeedService needService;

    @Autowired
    UserService userService;

    // Getting need by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Need> getNeedById(@PathVariable Long id){
        return new ResponseEntity<>(needService.findNeedById(id), HttpStatus.OK);
    }

    // Creating a new need
    @PostMapping
    public ResponseEntity<Need> createNeed(@RequestBody Need need){
        return new ResponseEntity<>(needService.createNeed(need), HttpStatus.CREATED);
    }

    // Updating a need
    @PutMapping(value = "/{id}")
    public ResponseEntity<Need> updateNeed(@RequestBody Need need, @PathVariable Long id){
        return new ResponseEntity<>(needService.updateNeed(need, id), HttpStatus.ACCEPTED);
    }

    // Deleting a need
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteNeed(@PathVariable Long id){
        needService.deleteNeed(id);
        return new ResponseEntity("This need has been deleted", HttpStatus.OK);
    }

    // Assigning a need to a user
    @PatchMapping(value = "/{need_id}/{user_id}")
    public ResponseEntity<Need> addingNeedToUser(@PathVariable Long need_id, @PathVariable Long user_id){
        Need needAssigned = needService.assignNeedToUser(need_id, user_id);
        return new ResponseEntity<>(needAssigned, HttpStatus.OK);
    }



}
