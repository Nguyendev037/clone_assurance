package com.example.durian_assurance.controllers.users;

import com.example.durian_assurance.repositories.users.ClientRepository;
import com.example.durian_assurance.services.users.ClientService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RestController
@RequestMapping("/client")
public class ClientController {
    ClientService clientService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createClient(@RequestParam(value = "userId") Long userId){
        clientService.createClient(userId);
        return "Create client successfully";
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Long getClientIDByUserId(@PathVariable Long userId ) {
        return clientService.getClientIDByUserId(userId);
    }

}
