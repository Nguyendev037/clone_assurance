package com.example.durian_assurance.models.payments;

import com.example.durian_assurance.models.BaseEntity;
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
@Table(name = "payments")
public class Payment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "signed_offer_id", nullable = false)
    SignedOffer signedOffer;

    @Column(name = "payment_date", nullable = false)
    LocalDate paymentDate;

    @Column(nullable = false)
    BigDecimal amount;

    @Lob
    @Column(name = "description", columnDefinition = "TEXT")
    String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "transfer_id")
    User transferer;
}
