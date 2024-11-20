package com.example.durian_assurance.models.payments;

import com.example.durian_assurance.models.BaseEntity;
import com.example.durian_assurance.models.offers.CasesInOffers;
import com.example.durian_assurance.models.offers.SignedOffer;
import com.example.durian_assurance.models.users.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "payouts")
public class Payout extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "signed_offer_id", nullable = false)
    SignedOffer signedOffer;

    @OneToOne
    @JoinColumn(name = "claim_id", referencedColumnName = "id")
    Claim claim;

    @Column(name = "payment_date", nullable = false)
    LocalDate payoutDate;

    @Column(nullable = false)
    BigDecimal amount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "case_id")
    CasesInOffers casePayout;

    @ManyToOne(optional = false)
    @JoinColumn(name = "receiver_id")
    User receiver;
}
