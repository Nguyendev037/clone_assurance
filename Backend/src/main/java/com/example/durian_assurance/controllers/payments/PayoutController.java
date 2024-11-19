package com.example.durian_assurance.controllers.payments;

import com.example.durian_assurance.dto.requests.PayoutRequest;
import com.example.durian_assurance.dto.responses.PayoutResponse;
import com.example.durian_assurance.services.payments.PayoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payout")
public class PayoutController {
    private final PayoutService payoutService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String makePayment(@RequestBody PayoutRequest request){
        payoutService.makePayout(request);
        return "Successful payout";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PayoutResponse> getBySignedOffer(@RequestParam(value = "offer_id") String id){
        return payoutService.getBySignedOffer(id);
    }
}
