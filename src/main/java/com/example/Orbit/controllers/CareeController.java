package com.example.Orbit.controllers;

import com.example.Orbit.services.CareeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/carees")
public class CareeController {

    @Autowired
    CareeService careeService;

    @GetMapping
    public ResponseEntity

}
