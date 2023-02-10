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

    public List<Caree> getAllCarees(){
        return careeRepository.findAll();
    }

    // UpdateCaree, deleteCaree, createCaree, findCareeById(), findCareeByUniqueCode()
    public Caree findCareeById(Long id) {
        return careeRepository.findById(id).get();
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

        if(caree.getName() != null){
            updatedCaree.setName(caree.getName());
        }

        if(caree.getAge() != 0 && caree.getAge() <200 ){
            updatedCaree.setAge(caree.getAge());
        }

        if(caree.getBio() !=null){
            updatedCaree.setBio(caree.getBio());
        }

        if (caree.getToDoList() != null){
            updatedCaree.setToDoList(caree.getToDoList());

        }

        careeRepository.save(updatedCaree);
        return updatedCaree;
    }
}
