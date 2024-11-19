package com.example.durian_assurance.repositories.users;

import com.example.durian_assurance.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
