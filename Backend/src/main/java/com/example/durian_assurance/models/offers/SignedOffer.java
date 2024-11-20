package com.example.durian_assurance.models.offers;

import com.example.durian_assurance.models.BaseEntity;
import com.example.durian_assurance.models.payments.Payment;
import com.example.durian_assurance.models.payments.Payout;
import com.example.durian_assurance.models.users.Client;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="signed_offers")
@Builder
public class SignedOffer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "signedOffer")
    private Set<Payment> payments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "signedOffer")
    private Set<Payout> payouts;
}
