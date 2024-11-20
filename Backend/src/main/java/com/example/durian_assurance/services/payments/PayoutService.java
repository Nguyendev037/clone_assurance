package com.example.durian_assurance.services.payments;

import com.example.durian_assurance.dto.requests.PayoutRequest;
import com.example.durian_assurance.dto.responses.PayoutResponse;
import com.example.durian_assurance.exceptions.NotFoundException;
import com.example.durian_assurance.models.payments.Payout;
import com.example.durian_assurance.repositories.payments.PayoutRepository;
import com.example.durian_assurance.services.offers.CaseService;
import com.example.durian_assurance.services.offers.SignedOfferService;
import com.example.durian_assurance.services.users.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
public class PayoutService {
    PayoutRepository payoutRepository;
    SignedOfferService signedOfferService;
    CaseService caseService;
    UserService userService;

    public List<Payout> getPayOut() {
        return payoutRepository.findAll();
    }

    public Payout getPayOutById (Long id ) {
        return payoutRepository.findById(id).orElseThrow(()-> new NotFoundException("Payout is not exist"));
    }

    public void makePayout(PayoutRequest request){
        Payout payout = Payout.builder()
                .payoutDate(LocalDate.now())
                .amount(request.getAmount())
                .receiver(userService.findById(request.getReceiverId()))
//              .signedOffer(signedOfferService.findById())
//              .caseId(caseService.findById())
                .build();
        payoutRepository.save(payout);
    }

    public List<PayoutResponse> getBySignedOffer(String id){
        return payoutRepository.findBySignedOfferId(id).stream().map(PayoutResponse::toResponse).toList();
    }
}
