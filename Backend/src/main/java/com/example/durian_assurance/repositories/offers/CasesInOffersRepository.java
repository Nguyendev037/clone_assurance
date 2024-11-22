package com.example.durian_assurance.repositories.offers;

import com.example.durian_assurance.models.offers.CasesInOffers;
import com.example.durian_assurance.models.offers.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CasesInOffersRepository extends JpaRepository<CasesInOffers, Long> {
    public List<CasesInOffers> findByOffer(Offer offer);

    public Optional<CasesInOffers> findByCaseTypeId(Long id);
}
