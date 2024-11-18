package com.example.Durian_Assurance.controllers;

import com.example.Durian_Assurance.services.ClientService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RestController
@RequestMapping("/client")
public class ClientController {
    ClientService clientService;

    @PostMapping("/{id}")
    public String createClient(@PathVariable(value = "id")Long id){
        clientService.createClient(id);
        return "Create client successfully";
    }
}
