package com.example.Orbit.repositories;
import com.example.Orbit.models.Caree;
import com.example.Orbit.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findUserById(Long id);

    List<User> findUserByLocation(String location);

    List<User> findUserByName(String name);

    User findByEmailAddress(String emailAddress);

    User findByPassword(String password);

    List<User> findAllByToDoListCareeId(Long careeId);

//    List<User> findUserByCaree(List<Caree> careeList);
}
