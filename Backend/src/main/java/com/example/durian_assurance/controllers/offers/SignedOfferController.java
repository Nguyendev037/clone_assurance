package com.example.durian_assurance.controllers.offers;

import com.example.durian_assurance.dto.requests.SignedOfferRequest;
import com.example.durian_assurance.models.offers.SignedOffer;
import com.example.durian_assurance.services.offers.SignedOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sign")
@RequiredArgsConstructor
public class SignedOfferController {
    private final SignedOfferService signedOfferService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SignedOffer addOffer(@RequestBody SignedOfferRequest request){
        return signedOfferService.createSignedOffer(request);
    }
}
