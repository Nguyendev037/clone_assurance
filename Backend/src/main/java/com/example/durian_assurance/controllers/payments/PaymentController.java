package com.example.durian_assurance.controllers.payments;

import com.example.durian_assurance.dto.requests.PaymentRequest;
import com.example.durian_assurance.dto.responses.PaymentResponse;
import com.example.durian_assurance.services.payments.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String makePayment(@RequestBody PaymentRequest request){
        paymentService.makePayment(request);
        return "Successful payment";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PaymentResponse> getBySignedOffer(@RequestParam(value = "offer_id") String id){
        return paymentService.getBySignedOffer(id);
    }
}
