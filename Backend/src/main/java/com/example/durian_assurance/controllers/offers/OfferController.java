package com.example.durian_assurance.controllers.offers;


import com.example.durian_assurance.dto.requests.CreateOfferRequest;
import com.example.durian_assurance.iservices.IOfferService;
import com.example.durian_assurance.models.offers.Offer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class OfferController {
    private final IOfferService offerService;

    @GetMapping
    public List<Offer> getAllOffer(){
        return offerService.getAllOffer();
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
    public Offer getOfferById(@PathVariable(value = "id") Long id){
        return offerService.getOfferById(id);
    }
}
