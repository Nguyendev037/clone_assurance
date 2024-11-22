package com.example.durian_assurance.dto.responses;

import com.example.durian_assurance.models.offers.CasesInOffers;
import com.example.durian_assurance.models.offers.Offer;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class OfferResponse {
    Long id;
    String name;
    String description;
    int years;
    BigDecimal payoutAmount;
    @JsonManagedReference
    Set<CasesInOfferResponse> cases;

    public static OfferResponse mapToDTO(Offer offer) {
        return OfferResponse.builder()
                .id(offer.getId())
                .name(offer.getName())
                .years(offer.getYears())
                .payoutAmount(offer.getPayoutAmount())
                .cases(offer.getCases().stream().map(CasesInOfferResponse::toResponse).collect(Collectors.toSet()))
                .build();
    }
}
