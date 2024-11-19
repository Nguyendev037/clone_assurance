package com.example.durian_assurance.controllers.payments;

import com.example.durian_assurance.services.payments.ClaimService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/claim")
@RequiredArgsConstructor
public class ClaimController {
    private final ClaimService claimService;
}
