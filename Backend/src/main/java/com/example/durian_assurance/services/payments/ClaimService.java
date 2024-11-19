package com.example.durian_assurance.services.payments;

import com.example.durian_assurance.repositories.payments.ClaimRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ClaimService {
    ClaimRepository claimRepository;
}
