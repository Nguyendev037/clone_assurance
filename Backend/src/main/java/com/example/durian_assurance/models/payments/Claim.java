package com.example.durian_assurance.models.payments;

import com.example.durian_assurance.models.enums.Status;
import com.example.durian_assurance.models.offers.SignedOffer;
import com.example.durian_assurance.models.users.Client;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "claims")
public class Claim implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;

    @Column(name = "signed_offer_id")
    SignedOffer signedOffer;

    String description;

    LocalDate claimDate;

    String hospital;

    LocalDate admissionDate;

    LocalDate dischargeDate;

    String diagnosis;

    BigDecimal payoutAmount;

    @Enumerated(EnumType.STRING)
    Status status;

    String reason;

    @OneToOne
    @JoinColumn(name = "payout_id", referencedColumnName = "id")
    Payout payout;
}
