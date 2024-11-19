package com.example.durian_assurance.dto.responses;

import com.example.durian_assurance.models.payments.Payment;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentResponse {
    Long id;
    String signedOfferId;
    LocalDate paymentDate;
    BigDecimal amount;
    String description;
    Long transfererId;

    public static PaymentResponse toResponse(Payment payment){
        return PaymentResponse.builder()
                .id(payment.getId())
                .signedOfferId(payment.getSignedOffer().getId())
                .paymentDate(payment.getPaymentDate())
                .amount(payment.getAmount())
                .description(payment.getDescription())
                .transfererId(payment.getTransferer().getId())
                .build();
    }
}