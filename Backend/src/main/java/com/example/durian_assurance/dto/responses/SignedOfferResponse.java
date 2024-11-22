package com.example.durian_assurance.dto.responses;

import com.example.durian_assurance.models.offers.SignedOffer;
import com.example.durian_assurance.models.payments.Payment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class SignedOfferResponse {
    private String id;
    private Long clientId;
    private OfferResponse offer;
    private boolean isActive;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal paymentAmount;

    public static SignedOfferResponse toResponse(SignedOffer offer){
        return SignedOfferResponse.builder()
                .id(offer.getId())
                .clientId(offer.getClient().getId())
                .offer(OfferResponse.mapToDTO(offer.getOffer()))
                .isActive(offer.isActive())
                .startDate(offer.getStartDate())
                .endDate(offer.getEndDate())
                .paymentAmount(BigDecimal.valueOf(offer.getPayments().stream()
                        .map(Payment::getAmount)
                        .mapToDouble(BigDecimal::doubleValue)
                        .sum()))
                .build();
    }
}
