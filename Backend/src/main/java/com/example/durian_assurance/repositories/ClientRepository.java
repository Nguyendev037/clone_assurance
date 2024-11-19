package com.example.durian_assurance.repositories;

import com.example.durian_assurance.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
