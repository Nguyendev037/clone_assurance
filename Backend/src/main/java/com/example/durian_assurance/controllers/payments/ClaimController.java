package com.example.durian_assurance.controllers.payments;

import com.example.durian_assurance.dto.requests.ClaimRequest;
import com.example.durian_assurance.dto.responses.PayoutResponse;
import com.example.durian_assurance.services.payments.ClaimService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/claim")
@RequiredArgsConstructor
public class ClaimController {
    private final ClaimService claimService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createClaim(@RequestBody ClaimRequest request){
        claimService.createClaim(request);
        return "Successful payout";
    }

    @PostMapping("/decline")
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String getClaimByID(@RequestParam(value = "claim_id") Long id, @RequestParam(value = "reason") String reason){
        claimService.declineClaim(id, reason);
        return "Claim declined";
    }
}
