package com.example.Durian_Assurance.repositories;

import com.example.Durian_Assurance.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
