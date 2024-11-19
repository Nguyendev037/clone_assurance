package com.example.durian_assurance.services.offers;

import com.example.durian_assurance.dto.requests.SignedOfferRequest;
import com.example.durian_assurance.models.offers.Offer;
import com.example.durian_assurance.models.offers.SignedOffer;
import com.example.durian_assurance.services.users.ClientService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SignedOfferService {
    OfferService offerService;
    ClientService clientService;

    public SignedOffer createSignedOffer(SignedOfferRequest request){
        Offer offer = offerService.getOfferById(request.getOfferId());
        LocalDate startDate = request.getStartDate();
        return SignedOffer.builder()
                .client(clientService.getClientById(request.getClientId()))
                .offer(offer)
                .startDate(startDate)
                .endDate(startDate.plusYears(offer.getYears()))
                .build();
    }
}
