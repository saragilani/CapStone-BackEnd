package com.example.Orbit.controllers;

import com.example.Orbit.models.Caree;
import com.example.Orbit.services.CareeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value= "/carees")
public class CareeController {

    @Autowired
    CareeService careeService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Caree>> getCareeById(@PathVariable Long id){
        return new ResponseEntity<>(careeService.findCareeById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{uniqueCode}")
    public ResponseEntity<List<Caree>> getCareeByUniqueCode(@PathVariable String uniqueCode){
        return new ResponseEntity<>(careeService.findCareeByUniqueCode(uniqueCode), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Caree> createCaree(@RequestBody Caree caree) {
        return new ResponseEntity<>(careeService.createCaree(caree), HttpStatus.OK);
    }

    @PatchMapping (value = "/{id}")
    public ResponseEntity<Caree> updateCaree(@RequestBody Caree caree, @PathVariable Long id){
        return new ResponseEntity<>(careeService.updateCaree(id, caree), HttpStatus.ACCEPTED);
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity deleteCaree(@PathVariable Long id) {
        careeService.deleteCaree(id);
        return new ResponseEntity("You successfully deleted the caree", HttpStatus.OK);
    }

}
