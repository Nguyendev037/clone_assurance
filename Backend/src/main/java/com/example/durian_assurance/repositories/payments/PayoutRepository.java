package com.example.durian_assurance.repositories.payments;

import com.example.durian_assurance.models.payments.Payout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PayoutRepository extends JpaRepository<Payout,Long> {
    List<Payout> findBySignedOfferId(String signedOfferId);
}
