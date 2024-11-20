package com.example.durian_assurance.dto.requests;

import com.example.durian_assurance.models.offers.SignedOffer;
import com.example.durian_assurance.models.users.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentRequest {
    String signedOfferId;
    BigDecimal amount;
    String description;
    Long transfererId;
}

