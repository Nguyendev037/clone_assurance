package com.example.durian_assurance.iservices;

import com.example.durian_assurance.dto.requests.CreateOfferRequest;
import com.example.durian_assurance.dto.responses.OfferResponse;
import com.example.durian_assurance.models.offers.Offer;

import java.util.List;

public interface IOfferService {
    Offer createOffer(CreateOfferRequest product);

    Offer getOfferById(Long offerId);

    List<Offer> getAllOffer();

    Offer updateOffer(Long id, CreateOfferRequest product);

    void deleteOffer(Long id);
}
