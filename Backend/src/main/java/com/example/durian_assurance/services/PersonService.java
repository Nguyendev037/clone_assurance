package com.example.durian_assurance.services;

import com.example.durian_assurance.dto.requests.CreatePersonRequest;
import com.example.durian_assurance.dto.requests.UpdatePersonRequest;
import com.example.durian_assurance.dto.responses.PersonResponse;
import com.example.durian_assurance.iservices.IPersonService;
import com.example.durian_assurance.models.Person;
import com.example.durian_assurance.repositories.PersonRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class PersonService implements IPersonService {
    PersonRepository personRepository;

    public Person findById(Long id){
        return personRepository.findById(id).orElseThrow(()->new RuntimeException("Person with id " + id + " not found"));
    }

    @Override
    public PersonResponse createPerson(CreatePersonRequest request) {
        Person person = Person.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .bankAccount(request.getBankAccount())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build();
        personRepository.save(person);
        return PersonResponse.toPersonResponse(person);
    }

    @Override
    public PersonResponse getPerson(Long id) {
        return PersonResponse.toPersonResponse(findById(id));
    }

    @Override
    public List<PersonResponse> getAllPeople() {
        return personRepository.findAll().stream().map(PersonResponse::toPersonResponse).toList();
    }

    @Override
    public PersonResponse updatePerson(Long id, UpdatePersonRequest request) {
        Person person = findById(id);
        person.setFirstName(request.getFirstName());
        person.setLastName(request.getLastName());
        person.setAddress(request.getAddress());
        person.setPhone(request.getPhone());

        personRepository.save(person);
        return PersonResponse.toPersonResponse(person);
    }
}