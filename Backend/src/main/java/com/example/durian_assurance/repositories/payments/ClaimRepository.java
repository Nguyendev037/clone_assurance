package com.example.durian_assurance.repositories.payments;

import com.example.durian_assurance.models.payments.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim,Long> {
}
