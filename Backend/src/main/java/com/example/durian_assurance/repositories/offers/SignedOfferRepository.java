package com.example.durian_assurance.repositories.offers;

import com.example.durian_assurance.models.offers.SignedOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignedOfferRepository extends JpaRepository<SignedOffer, String> {
}
