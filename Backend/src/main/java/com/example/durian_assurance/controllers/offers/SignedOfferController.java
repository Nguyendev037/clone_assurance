package com.example.durian_assurance.controllers.offers;

import com.example.durian_assurance.models.offers.SignedOffer;
import com.example.durian_assurance.services.offers.SignedOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign")
@RequiredArgsConstructor
public class SignedOfferController {
    private final SignedOfferService signedOfferService;

    @GetMapping("/{user_id}")
    public List<SignedOffer> getAllSignedOffer {

    }

}
