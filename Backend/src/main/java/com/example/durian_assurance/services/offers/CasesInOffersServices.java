package com.example.durian_assurance.services.offers;

import com.example.durian_assurance.models.offers.CasesInOffers;
import com.example.durian_assurance.repositories.offers.CasesInOffersRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CasesInOffersServices {
    CasesInOffersRepository casesInOffersRepository;

}
