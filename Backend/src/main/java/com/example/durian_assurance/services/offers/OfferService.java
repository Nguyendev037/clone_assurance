package com.example.durian_assurance.services.offers;

import com.example.durian_assurance.dto.requests.CreateOfferRequest;
import com.example.durian_assurance.exceptions.NotFoundException;
import com.example.durian_assurance.iservices.IOfferService;
import com.example.durian_assurance.models.offers.Offer;
import com.example.durian_assurance.repositories.offers.OfferRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OfferService implements IOfferService {

    private final OfferRepository offerRepository;

    @Override
    public Offer createOffer(CreateOfferRequest offerDTO) {
        Offer newOffer = Offer
                .builder()
                .name(offerDTO.getName())
                .description(offerDTO.getDescription())
                .years(offerDTO.getYears())
                .payoutAmount(offerDTO.getPayoutAmount())
                .build();
        return offerRepository.save(newOffer);
    }

    @Override
    public Offer getOfferById(Long offerId) {
        return offerRepository.findById(offerId).orElseThrow(()->new NotFoundException("Can not find offer with id: " + offerId));
    }

    @Override
    public List<Offer> getAllOffer() {
        return offerRepository.findAll();
    }

    @Override
    public Offer updateOffer(Long id, CreateOfferRequest offerDTO) {
        Offer existingOffer = getOfferById(id);
        existingOffer.setName(offerDTO.getName());

        return null;
    }

    @Override
    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }
}


