package com.example.durian_assurance.dto.responses;

import com.example.durian_assurance.models.offers.Case;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CaseResponse {
    long id;
    String name;
    String description;

    public static CaseResponse toResponse(Case dto){
        return CaseResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }
}
