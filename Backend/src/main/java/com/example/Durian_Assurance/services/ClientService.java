package com.example.Durian_Assurance.services;

import com.example.Durian_Assurance.iservices.IClientService;
import com.example.Durian_Assurance.models.Client;
import com.example.Durian_Assurance.repositories.ClientRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

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
