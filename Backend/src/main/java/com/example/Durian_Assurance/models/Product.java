package com.example.Durian_Assurance.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="products")
@Builder

public class Product extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private Long productCategory;
    private String productDescription;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long paymentAmount;

}
