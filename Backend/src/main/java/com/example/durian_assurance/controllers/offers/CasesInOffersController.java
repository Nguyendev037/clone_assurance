package com.example.durian_assurance.controllers.offers;

import com.example.durian_assurance.services.offers.CasesInOffersServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class CasesInOffersController {
    private final CasesInOffersServices casesInOffersServices;
}
