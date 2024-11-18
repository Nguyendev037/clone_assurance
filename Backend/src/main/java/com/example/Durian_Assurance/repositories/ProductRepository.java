package com.example.Durian_Assurance.repositories;

import com.example.Durian_Assurance.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
