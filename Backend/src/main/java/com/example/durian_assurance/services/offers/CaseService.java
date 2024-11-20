package com.example.durian_assurance.services.offers;

import com.example.durian_assurance.dto.requests.CreateCaseRequest;
import com.example.durian_assurance.exceptions.NotFoundException;
import com.example.durian_assurance.models.offers.Case;
import com.example.durian_assurance.repositories.offers.CaseRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CaseService {
    CaseRepository caseRepository;

    public Case createCase(CreateCaseRequest request) {
        return caseRepository.save(Case.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build());
    }

    public Case getById(Long id){
        return caseRepository.findById(id).orElseThrow(()->new NotFoundException("Can not find case with id: " + id));
    }
}
