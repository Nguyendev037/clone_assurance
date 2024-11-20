package com.example.durian_assurance.services.payments;

import com.example.durian_assurance.dto.requests.ClaimRequest;
import com.example.durian_assurance.exceptions.NotFoundException;
import com.example.durian_assurance.models.enums.Status;
import com.example.durian_assurance.models.offers.SignedOffer;
import com.example.durian_assurance.models.payments.Claim;
import com.example.durian_assurance.models.users.Client;
import com.example.durian_assurance.repositories.payments.ClaimRepository;
import com.example.durian_assurance.services.offers.SignedOfferService;
import com.example.durian_assurance.services.users.ClientService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ClaimService {
    ClaimRepository claimRepository;
    SignedOfferService signedOfferService;
    ClientService clientService;

    public void createClaim(ClaimRequest request) {
        SignedOffer signedOffer = signedOfferService.getById(request.getSignedOffer());
        Client client = clientService.getClientById(request.getClientId());

        claimRepository.save(Claim.builder()
                .admissionDate(request.getAdmissionDate())
                .dischargeDate(request.getDischargeDate())
                .diagnosis(request.getDiagnosis())
                .description(request.getDescription())
                .hospital(request.getHospital())
                .status(Status.PENDING)
                .client(client)
                .payoutAmount(request.getPayoutAmount())
                .claimDate(LocalDate.now())
                .signedOffer(signedOffer)
                .build());
    }

    public Claim getById(Long id){
        return claimRepository.findById(id).orElseThrow(()->new NotFoundException("Can not find claim with id: "+ id));
    }

    public Claim acceptedClaim(Long id){
        Claim claim = getById(id);
        claim.setStatus(Status.ACCEPTED);
        return claimRepository.save(claim);
    }

    public void declineClaim(Long id, String reason){
        Claim claim = getById(id);
        claim.setStatus(Status.DENIED);
        claim.setReason(reason);
        claimRepository.save(claim);
    }
}
