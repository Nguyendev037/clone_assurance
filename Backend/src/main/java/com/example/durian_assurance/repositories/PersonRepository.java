package com.example.durian_assurance.repositories;

import com.example.durian_assurance.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
