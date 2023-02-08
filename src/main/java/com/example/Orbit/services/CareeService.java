package com.example.Orbit.services;

import com.example.Orbit.models.Caree;
import com.example.Orbit.repositories.CareeRepository;
import com.example.Orbit.repositories.NeedRepository;
import com.example.Orbit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CareeService {

    @Autowired
    NeedRepository needRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CareeRepository careeRepository;


    // UpdateCaree, deleteCaree, createCaree, findCareeById(), findCareeByUniqueCode()
    public Optional<Caree> findCareeById(Long id) {
        return careeRepository.findById(id);
    }

    public List<Caree> findCareeByUniqueCode(String uniqueCode) {
        return careeRepository.findByUniqueCode(uniqueCode);
    }

    public Caree createCaree(Caree caree) {
        careeRepository.save(caree);
        return caree;
    }

    public void deleteCaree(Long id) {
        careeRepository.deleteById(id);
    }

    public Caree updateCaree(Long id, Caree caree) {
        Caree updatedCaree = careeRepository.findById(id).get();
        updatedCaree.setName(caree.getName());
        updatedCaree.setAge(caree.getAge());
        updatedCaree.setBio(caree.getBio());
        updatedCaree.setToDoList(caree.getToDoList());
        careeRepository.save(updatedCaree);
        return updatedCaree;
    }
}
