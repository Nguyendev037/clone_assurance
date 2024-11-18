package com.example.Durian_Assurance.controllers;

import com.example.Durian_Assurance.dto.requests.CreatePersonRequest;
import com.example.Durian_Assurance.dto.requests.UpdatePersonRequest;
import com.example.Durian_Assurance.dto.responses.PersonResponse;
import com.example.Durian_Assurance.services.PersonService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RestController
@RequestMapping("/person")
public class PersonController {
    PersonService personService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonResponse createPerson(@RequestBody CreatePersonRequest request){
        return personService.createPerson(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonResponse getPerson(@PathVariable(value = "id")Long id){
        return personService.getPerson(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PersonResponse> getPeople(){
        return personService.getAllPeople();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonResponse updatePerson(@PathVariable(value = "id")Long id, @RequestBody UpdatePersonRequest request){
        return personService.updatePerson(id,request);
    }
}
