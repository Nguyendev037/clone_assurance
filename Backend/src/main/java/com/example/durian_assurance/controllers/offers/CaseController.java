package com.example.durian_assurance.controllers.offers;

import com.example.durian_assurance.services.offers.CaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case")
@RequiredArgsConstructor
public class CaseController {
    private final CaseService caseService;

    @GetMapping






}
