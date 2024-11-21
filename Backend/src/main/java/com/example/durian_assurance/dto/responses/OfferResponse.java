package com.example.durian_assurance.dto.responses;

import com.example.durian_assurance.models.offers.CasesInOffers;
import com.example.durian_assurance.models.offers.Offer;
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
    Set<String> caseNames;

    public static OfferResponse mapToDTO(Offer offer) {
        return OfferResponse.builder()
                .id(offer.getId())
                .name(offer.getName())
                .years(offer.getYears())
                .payoutAmount(offer.getPayoutAmount())
                .caseNames(
                        offer.getCases().stream().map(c -> c.getCaseType().getName()).collect(Collectors.toSet())
                )
                .build();
    }

}
