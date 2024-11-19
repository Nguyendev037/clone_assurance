package com.example.durian_assurance.repositories.offers;

import com.example.durian_assurance.models.offers.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
