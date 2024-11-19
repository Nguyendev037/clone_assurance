package com.example.durian_assurance.services;

import com.example.durian_assurance.iservices.IClientService;
import com.example.durian_assurance.models.Client;
import com.example.durian_assurance.repositories.ClientRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class ClientService implements IClientService {
    ClientRepository clientRepository;
    PersonService personService;

    @Override
    public void createClient(Long id) {
        personService.findById(id);
        clientRepository.save(Client.builder().id(id).build());
    }
}
