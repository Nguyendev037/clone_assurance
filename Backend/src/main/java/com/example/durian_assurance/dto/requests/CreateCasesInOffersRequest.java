package com.example.durian_assurance.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateCasesInOffersRequest {
    @JsonProperty("case_id")
    Long caseId;

    String details;
}
