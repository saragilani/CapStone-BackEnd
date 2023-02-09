package com.example.Orbit.services;

import com.example.Orbit.models.Need;
import com.example.Orbit.repositories.CareeRepository;
import com.example.Orbit.repositories.NeedRepository;
import com.example.Orbit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NeedService {

    @Autowired
    NeedRepository needRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CareeRepository careeRepository;

    public Optional<Need> findNeedById(Long id){
        return needRepository.findById(id);
    }

    public Need createNeed(Need need){
        needRepository.save(need);
        return need;
    }

    public Need updateNeed(Need need, Long id){
        Need updatedNeed = needRepository.findById(id).get();
        updatedNeed.setName(need.getName());
        updatedNeed.setDescription(need.getDescription());
        updatedNeed.setCompleted(need.getCompleted());
        updatedNeed.setUser(need.getUser());
        updatedNeed.setCaree(need.getCaree());
        needRepository.save(updatedNeed);
        return updatedNeed;
    }

    public void deleteNeed(Long id){
        needRepository.deleteById(id);
    }




}
