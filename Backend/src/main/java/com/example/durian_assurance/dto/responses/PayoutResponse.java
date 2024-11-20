package com.example.durian_assurance.dto.responses;

import com.example.durian_assurance.models.payments.Payout;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PayoutResponse{
    Long id;
    String signedOfferId;
    LocalDate payoutDate;
    BigDecimal amount;
    Long caseId;
    Long receiverId;

    public static PayoutResponse toResponse(Payout payout){
        return PayoutResponse.builder()
                .id(payout.getId())
                .signedOfferId(payout.getSignedOffer().getId())
                .payoutDate(payout.getPayoutDate())
                .amount(payout.getAmount())
                .caseId(payout.getCasePayout().getId())
                .receiverId(payout.getReceiver().getId())
                .build();
    }
}
