package com.example.Orbit.services;

import com.example.Orbit.models.Caree;
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
    public Need findNeedById(Long id){
        return needRepository.findById(id).get();
    }

    // creating a new need
    public Need createNeed(Need need){
        needRepository.save(need);
        return need;
    }

    // updating need
    public Need updateNeed(Need need, Long id){
        Need updatedNeed = needRepository.findById(id).get();
        if(need.getName() != null ){
            updatedNeed.setName(need.getName());
        }

        if(need.getDescription() != null){
            updatedNeed.setDescription(need.getDescription());
        }

        if(need.getCompleted() != null){
            updatedNeed.setCompleted(need.getCompleted());
        }

        if(need.getUser() != null) {
            updatedNeed.setUser(need.getUser());
        }

        if(need.getCaree() != null){
            updatedNeed.setCaree(need.getCaree());
        }

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

    // assigning a need to caree


}
