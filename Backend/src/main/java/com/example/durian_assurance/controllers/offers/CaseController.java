package com.example.durian_assurance.controllers.offers;

import com.example.durian_assurance.dto.requests.CreateCaseRequest;
import com.example.durian_assurance.models.offers.Case;
import com.example.durian_assurance.services.offers.CaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/case")
@RequiredArgsConstructor
public class CaseController {
    private final CaseService caseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Case addOffer(@RequestBody CreateCaseRequest request){
        return caseService.createCase(request);
    }
}
