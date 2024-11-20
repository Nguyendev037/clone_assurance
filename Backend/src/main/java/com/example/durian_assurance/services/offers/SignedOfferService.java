package com.example.durian_assurance.services.offers;

import com.example.durian_assurance.dto.requests.SignedOfferRequest;
import com.example.durian_assurance.exceptions.NotFoundException;
import com.example.durian_assurance.models.offers.Offer;
import com.example.durian_assurance.models.offers.SignedOffer;
import com.example.durian_assurance.repositories.offers.SignedOfferRepository;
import com.example.durian_assurance.services.users.ClientService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SignedOfferService {
    SignedOfferRepository signedOfferRepository;
    OfferService offerService;
    ClientService clientService;

    public SignedOffer createSignedOffer(SignedOfferRequest request){
        Offer offer = offerService.getOfferById(request.getOfferId());
        LocalDate startDate = request.getStartDate();
        SignedOffer signedOffer = SignedOffer.builder()
                .client(clientService.getClientById(request.getClientId()))
                .offer(offer)
                .startDate(startDate)
                .endDate(startDate.plusYears(offer.getYears()))
                .isActive(true)
                .payments(new HashSet<>())
                .payouts(new HashSet<>())
                .build();
        return signedOfferRepository.save(signedOffer);
    }

    public SignedOffer getById(String id){
        return signedOfferRepository.findById(id).orElseThrow(()->new NotFoundException("Can not find signed offer with id: " + id));
    }
}
