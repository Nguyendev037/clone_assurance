package com.example.durian_assurance.controllers.offers;


import com.example.durian_assurance.dto.requests.CreateOfferRequest;
import com.example.durian_assurance.dto.responses.OfferResponse;
import com.example.durian_assurance.iservices.IOfferService;
import com.example.durian_assurance.models.offers.Offer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class OfferController {
    private final IOfferService offerService;

    @GetMapping
    public List<OfferResponse> getAllOffer(){
        return offerService.getAllOffer().stream()
                .map(OfferResponse::mapToDTO)
                .toList();
    }

    @PostMapping
    public Offer addOffer(@RequestBody CreateOfferRequest request){
        return offerService.createOffer(request);
    }

    @PutMapping("/{id}")
    public Offer updateOffer(@PathVariable(value = "id") Long id, @RequestBody CreateOfferRequest request){
        return offerService.updateOffer(id, request);
    }

    @GetMapping("/{id}")
    public OfferResponse getOfferById(@PathVariable(value = "id") Long id){
        return OfferResponse.mapToDTO(offerService.getOfferById(id));
    }
}
