package com.example.Durian_Assurance.repositories;

import com.example.Durian_Assurance.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
