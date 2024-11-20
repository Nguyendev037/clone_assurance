package com.example.durian_assurance.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClaimRequest {
    @JsonProperty("client_id")
    Long clientId;

    @JsonProperty("signed_offer_id")
    String signedOffer;

    String description;

    String hospital;

    LocalDate admissionDate;

    LocalDate dischargeDate;

    String diagnosis;

    BigDecimal payoutAmount;
}
