package com.example.durian_assurance.services.users;

import com.example.durian_assurance.dto.responses.UserResponse;
import com.example.durian_assurance.exceptions.NotFoundException;
import com.example.durian_assurance.iservices.IClientService;
import com.example.durian_assurance.models.users.Client;
import com.example.durian_assurance.models.users.User;
import com.example.durian_assurance.repositories.users.ClientRepository;
import com.example.durian_assurance.services.offers.OfferService;
import com.example.durian_assurance.services.offers.SignedOfferService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class ClientService{
    ClientRepository clientRepository;
    UserService userService;
    OfferService offerService;

    public void createClient(Long userId) {
        User user = userService.findById(userId);
        clientRepository.save(Client.builder()
                .user(user)
                .build());
    }

    public Client getClientById(Long clientId){
        return clientRepository.findById(clientId).orElseThrow(()->new NotFoundException("Can not found client with id: " + clientId));
    }

    public Long getClientIDByUserId(Long userId) {
        return clientRepository.getClientIdByUserID(userId);
    }
    public List<UserResponse> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(client -> userService.findById(client.getUser().getId()))
                .map(UserResponse::toResponse)
                .toList();
    }
}
