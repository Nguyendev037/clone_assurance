package com.example.durian_assurance.services.payments;

import com.example.durian_assurance.dto.requests.PaymentRequest;
import com.example.durian_assurance.dto.responses.PaymentResponse;
import com.example.durian_assurance.models.payments.Payment;
import com.example.durian_assurance.repositories.payments.PaymentRepository;
import com.example.durian_assurance.services.offers.SignedOfferService;
import com.example.durian_assurance.services.users.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class PaymentService {
    PaymentRepository paymentRepository;
    SignedOfferService signedOfferService;
    UserService userService;

    public void makePayment(PaymentRequest request){
        Payment payment = Payment.builder()
                .amount(request.getAmount())
                .paymentDate(LocalDate.now())
                .description(request.getDescription())
//                .signedOffer(signedOfferService.findById())
                .transferer(userService.findById(request.getTransfererId()))
                .build();
        paymentRepository.save(payment);
    }

    public List<PaymentResponse> getBySignedOffer(String id){
        return paymentRepository.findBySignedOfferId(id).stream().map(PaymentResponse::toResponse).toList();
    }

}
