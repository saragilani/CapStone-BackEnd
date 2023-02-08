package com.example.Orbit.repositories;

import com.example.Orbit.models.Caree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CareeRepository extends JpaRepository<Caree, Long> {
    List<Caree> findByUniqueCode(String uniqueCode);
}
