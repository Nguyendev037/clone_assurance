package com.example.durian_assurance.dto.responses;

import com.example.durian_assurance.models.enums.Status;
import com.example.durian_assurance.models.payments.Claim;
import com.example.durian_assurance.models.payments.Payout;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class ClaimResponse {
    Long id;
    @JsonProperty("client_id")
    Long clientId;
    @JsonProperty("signed_offer_id")
    String signedOfferId;
    String description;
    LocalDate claimDate;
    String hospital;
    LocalDate admissionDate;
    LocalDate dischargeDate;
    String diagnosis;
    BigDecimal payoutAmount;
    Status status;
    String reason;
    @JsonProperty("payout_id")
    Long payoutId;

    public static ClaimResponse toResponse(Claim claim){
        Long payoutId = null;
        if (claim.getPayout() != null){
            payoutId = claim.getPayout().getId();
        }

        return ClaimResponse.builder()
                .id(claim.getId())
                .clientId(claim.getClient().getId())
                .signedOfferId(claim.getSignedOffer().getId())
                .description(claim.getDescription())
                .claimDate(claim.getClaimDate())
                .hospital(claim.getHospital())
                .admissionDate(claim.getAdmissionDate())
                .dischargeDate(claim.getDischargeDate())
                .diagnosis(claim.getDiagnosis())
                .payoutAmount(claim.getPayoutAmount())
                .status(claim.getStatus())
                .clientId(claim.getClient().getId())
                .reason(claim.getReason())
                .payoutId(payoutId)
                .build();
    }
}
