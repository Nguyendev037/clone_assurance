package com.example.durian_assurance.repositories.payments;

import com.example.durian_assurance.models.payments.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    List<Payment> findBySignedOfferId(String signedOfferId);
}
