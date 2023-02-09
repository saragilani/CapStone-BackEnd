package com.example.Orbit.services;

import com.example.Orbit.models.Need;
import com.example.Orbit.models.User;
import com.example.Orbit.repositories.CareeRepository;
import com.example.Orbit.repositories.NeedRepository;
import com.example.Orbit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NeedService {

    @Autowired
    NeedRepository needRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CareeRepository careeRepository;

    // finding a need by id
    public Optional<Need> findNeedById(Long id){
        return needRepository.findById(id);
    }

    // creating a new need
    public Need createNeed(Need need){
        needRepository.save(need);
        return need;
    }

    // updating need
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

    // deleting a need
    public void deleteNeed(Long id){
        needRepository.deleteById(id);
    }

    // assigning need to user
    // might need to move this into the user repository
    // as we want to return user/todolist of user rather than need
    // should test it out first and see
    public Need assignNeedToUser(Long need_id, Long user_id){
        Need need = needRepository.findById(need_id).get();
        User user = userRepository.findById(user_id).get();
        List<Need> toDoList = user.getToDoList();
        toDoList.add(need);
        user.setToDoList(toDoList);
        userRepository.save(user);
        return need;
    }

    // assign need t


}
