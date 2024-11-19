package com.example.durian_assurance.repositories.users;

import com.example.durian_assurance.models.users.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
