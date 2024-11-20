package com.example.durian_assurance.services.offers;

import com.example.durian_assurance.dto.requests.CreateOfferRequest;
import com.example.durian_assurance.exceptions.NotFoundException;
import com.example.durian_assurance.iservices.IOfferService;
import com.example.durian_assurance.models.offers.CasesInOffers;
import com.example.durian_assurance.models.offers.Offer;
import com.example.durian_assurance.repositories.offers.CasesInOffersRepository;
import com.example.durian_assurance.repositories.offers.OfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OfferService implements IOfferService {
    private final OfferRepository offerRepository;
    private final CasesInOffersRepository casesInOffersRepository;
    private final CaseService caseService;

    @Override
    public Offer createOffer(CreateOfferRequest offerDTO) {
        Offer newOffer = Offer.builder()
                .name(offerDTO.getName())
                .description(offerDTO.getDescription())
                .years(offerDTO.getYears())
                .payoutAmount(offerDTO.getPayoutAmount())
                .build();

        Set<CasesInOffers> cases = offerDTO.getCases().stream()
                .map(item -> CasesInOffers.builder()
                        .caseType(caseService.getById(item.getCaseId()))
                        .detail(item.getDetails())
                        .offer(newOffer) // Set the relationship
                        .build())
                .collect(Collectors.toSet());

        newOffer.setCases(cases);

        return offerRepository.save(newOffer);
    }


    @Override
    public Offer getOfferById(Long offerId) {
        return offerRepository.findById(offerId).orElseThrow(() -> new NotFoundException("Can not find offer with id: " + offerId));
    }

    @Override
    public List<Offer> getAllOffer() {
        return offerRepository.findAll();
    }

    @Override
    public Offer updateOffer(Long id, CreateOfferRequest offerDTO) {
        Offer existingOffer = getOfferById(id);
        existingOffer.setName(offerDTO.getName());
        existingOffer.setDescription(offerDTO.getDescription());
        existingOffer.setYears(offerDTO.getYears());
        existingOffer.setPayoutAmount(offerDTO.getPayoutAmount());

        Set<CasesInOffers> cases = offerDTO.getCases().stream()
                .map(item -> CasesInOffers.builder()
                        .caseType(caseService.getById(item.getCaseId()))
                        .detail(item.getDetails())
                        .offer(existingOffer) // Set the relationship
                        .build())
                .collect(Collectors.toSet());

        existingOffer.setCases(cases);

        return offerRepository.save(existingOffer);
    }

    @Override
    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }
}