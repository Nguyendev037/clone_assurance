package com.example.durian_assurance.dto.responses;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class SignedOfferResponse {
    private Long id;
    private Long clientId;
    private Long offerID;
    private boolean isActive;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal paymentAmount;
}
