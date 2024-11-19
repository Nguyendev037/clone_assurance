package com.example.durian_assurance.models.offers;


import com.example.durian_assurance.models.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "offers")
@Builder
public class Offer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private int years;

    private BigDecimal payoutAmount;

    @OneToMany(mappedBy = "offer", cascade = CascadeType.ALL)
    private Set<CasesInOffers> cases;
}
