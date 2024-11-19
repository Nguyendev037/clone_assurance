package com.example.durian_assurance.dto.requests;

import com.example.durian_assurance.models.offers.Offer;
import com.example.durian_assurance.models.payments.Payment;
import com.example.durian_assurance.models.payments.Payout;
import com.example.durian_assurance.models.users.Client;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class SignedOfferRequest {
    private Long clientId;
    private Long offerId;
    private LocalDate startDate;
}
