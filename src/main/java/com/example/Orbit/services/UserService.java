package com.example.Orbit.services;
import com.example.Orbit.models.Caree;
import com.example.Orbit.models.User;
import com.example.Orbit.repositories.CareeRepository;
import com.example.Orbit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CareeRepository careeRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        userRepository.save(user);

        return user;
    }

    public Optional <User> getUserById(Long id) {

        return userRepository.findById(id);
    }

    public Optional <User> findUserByEmailAddress(String emailAddress) {
         return userRepository.findUserByEmailAddress(emailAddress);
    }

    public User updateUser(User user, Long id){
        User userToUpdate = userRepository.findById(id).get();

        if(user.getName() != null){
             userToUpdate.setName(user.getName()); }

        return userRepository.save(userToUpdate);

    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    // add caree to user
    // get user id and caree id, authorise by adding to authorised list
    // check if user authorised before assigning needs
    // add authorisation layer later







}
