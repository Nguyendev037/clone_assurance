package com.example.durian_assurance.services.payments;

import com.example.durian_assurance.dto.requests.PayoutRequest;
import com.example.durian_assurance.dto.responses.PayoutResponse;
import com.example.durian_assurance.models.offers.CasesInOffers;
import com.example.durian_assurance.models.offers.SignedOffer;
import com.example.durian_assurance.models.payments.Payout;
import com.example.durian_assurance.repositories.offers.CasesInOffersRepository;
import com.example.durian_assurance.repositories.payments.PayoutRepository;
import com.example.durian_assurance.services.offers.CaseService;
import com.example.durian_assurance.services.offers.SignedOfferService;
import com.example.durian_assurance.services.users.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class PayoutService {
    PayoutRepository payoutRepository;
    SignedOfferService signedOfferService;
    CasesInOffersRepository casesInOffersRepository;
    UserService userService;

    public void makePayout(PayoutRequest request) {
        SignedOffer signedOffer = signedOfferService.getById(request.getSignedOfferId());

        CasesInOffers casePayout = casesInOffersRepository.findById(request.getCasePayoutId())
                .orElseThrow(() -> new RuntimeException("Can not find this case in offer"));

        boolean caseExistsInOffer = signedOffer.getOffer().getCases().stream()
                .anyMatch(aCase -> Objects.equals(aCase.getId(), casePayout.getId()));

        if (!caseExistsInOffer) {
            throw new RuntimeException("This case do not belong in this offer");
        }
        Payout payout = Payout.builder()
                .payoutDate(LocalDate.now())
                .amount(request.getAmount())
                .receiver(userService.findById(request.getReceiverId()))
                .signedOffer(signedOffer)
                .casePayout(casePayout)
                .build();
        payoutRepository.save(payout);
    }


    public List<PayoutResponse> getBySignedOffer(String id) {
        return payoutRepository.findBySignedOfferId(id).stream().map(PayoutResponse::toResponse).toList();
    }
}
