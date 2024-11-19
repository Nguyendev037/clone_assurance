package com.example.durian_assurance.repositories;

import com.example.durian_assurance.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
