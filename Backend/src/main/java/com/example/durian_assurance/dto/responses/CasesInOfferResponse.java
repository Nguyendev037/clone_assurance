package com.example.durian_assurance.dto.responses;

import com.example.durian_assurance.models.offers.Case;
import com.example.durian_assurance.models.offers.Offer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CasesInOfferResonse {
    private Long id;
    private Offer offer;
    @JsonBackReference
    private Case caseType;

    private String detail;
}
