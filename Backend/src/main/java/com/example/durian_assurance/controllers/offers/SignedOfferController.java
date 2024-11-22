package com.example.durian_assurance.controllers.offers;

import com.example.durian_assurance.dto.requests.SignedOfferRequest;
import com.example.durian_assurance.dto.responses.SignedOfferResponse;
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

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<SignedOfferResponse> getAllSignedOffer () {
        return signedOfferService.getAllSignedOffer().stream().map(SignedOfferResponse::toResponse).toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SignedOfferResponse getSingedById (@PathVariable String id) {
        return SignedOfferResponse.toResponse(signedOfferService.getById(id));
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public SignedOfferResponse createSignedOffer(@RequestBody SignedOfferRequest signedOfferDTO) {
        return SignedOfferResponse.toResponse(signedOfferService.createSignedOffer(signedOfferDTO));
    }


}
