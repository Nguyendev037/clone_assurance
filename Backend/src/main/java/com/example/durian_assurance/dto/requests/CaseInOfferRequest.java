package com.example.durian_assurance.dto.requests;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CaseInOfferRequest {
    String detail;
    Long caseTypeId;
    String caseTypeName;
}
