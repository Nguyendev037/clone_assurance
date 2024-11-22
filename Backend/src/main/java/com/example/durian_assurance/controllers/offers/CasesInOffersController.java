package com.example.durian_assurance.controllers.offers;

import com.example.durian_assurance.dto.responses.CasesInOfferResponse;
import com.example.durian_assurance.services.offers.CasesInOffersServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cases_in_offer")
@RequiredArgsConstructor
public class CasesInOffersController {
    private final CasesInOffersServices casesInOffersServices;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CasesInOfferResponse> getCasesInOffers(@RequestParam(value = "offer_id") Long id) {
        return casesInOffersServices.findCasesInOffer(id).stream().map(CasesInOfferResponse::toResponse).toList();
    }
}
