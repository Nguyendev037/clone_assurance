package com.example.durian_assurance.dto.requests;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PayoutRequest{
    Long signedOfferId;
    BigDecimal amount;
    Long caseId;
    Long receiverId;
}
