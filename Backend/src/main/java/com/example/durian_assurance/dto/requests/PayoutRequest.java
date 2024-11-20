package com.example.durian_assurance.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PayoutRequest{
    @JsonProperty("signed_offer_id")
    String signedOfferId;
    BigDecimal amount;
    @JsonProperty("case_payout_id")
    Long casePayoutId;
    @JsonProperty("receiver_id")
    Long receiverId;
    @JsonProperty("claim_id")
    Long claimId;
}
