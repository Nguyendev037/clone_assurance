package com.example.Durian_Assurance.dto.requests;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProductRequest  {

    @NotBlank(message = "Name is mandotory")
    private String name;

    private Long productCategory;

    private String productDescription;

    private LocalDate startDate;
    private LocalDate endDate;

    @Min(value=0, message="Price must be greater than or equal 0")
    @Max(value=100000000, message="Price must be less than or equal to 100,000,000")
    private Long paymentAmount;

}
