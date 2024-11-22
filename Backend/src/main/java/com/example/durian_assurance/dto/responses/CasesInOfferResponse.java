package com.example.durian_assurance.dto.responses;

import com.example.durian_assurance.models.offers.CasesInOffers;
import com.example.durian_assurance.models.offers.Offer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CasesInOfferResponse {
    private Long id;

    private Long offerId;

    private CaseResponse caseType;

    private String detail;

    public static CasesInOfferResponse toResponse(CasesInOffers cases) {
        return CasesInOfferResponse.builder()
                .offerId(cases.getOffer().getId())
                .detail(cases.getDetail())
                .caseType(CaseResponse.toResponse(cases.getCaseType()))
                .id(cases.getId())
                .build();
    }
}
