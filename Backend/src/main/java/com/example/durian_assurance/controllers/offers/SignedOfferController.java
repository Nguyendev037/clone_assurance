package com.example.durian_assurance.controllers.offers;

import com.example.durian_assurance.dto.requests.SignedOfferRequest;
import com.example.durian_assurance.models.offers.SignedOffer;
import com.example.durian_assurance.services.offers.SignedOfferService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sign")
@RequiredArgsConstructor

public class SignedOfferController {
    private final SignedOfferService signedOfferService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SignedOffer> getAllSignedOffer () {
        return signedOfferService.getAllSignedOffer();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SignedOffer getSingedById (@PathVariable String id) {
        return signedOfferService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public SignedOffer createSignedOffer(@RequestBody SignedOfferRequest signedOfferDTO) {
        return signedOfferService.createSignedOffer(signedOfferDTO);
    }
}
