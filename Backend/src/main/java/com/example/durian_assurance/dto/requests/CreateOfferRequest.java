package com.example.durian_assurance.dto.requests;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOfferRequest {

    @NotBlank(message = "Name is mandotory")
    private String name;

    private String description;

    private int years;

    @Min(value=0, message="Price must be greater than or equal 0")
    @Max(value=100000000, message="Price must be less than or equal to 100,000,000")
    private BigDecimal payoutAmount;

}
