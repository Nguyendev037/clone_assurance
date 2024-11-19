package com.example.durian_assurance.iservices;

import com.example.durian_assurance.dto.requests.CreatePersonRequest;
import com.example.durian_assurance.dto.requests.UpdatePersonRequest;
import com.example.durian_assurance.dto.responses.PersonResponse;

import java.util.List;

public interface IPersonService {
    public PersonResponse createPerson(CreatePersonRequest request);

    public PersonResponse getPerson(Long id);

    public List<PersonResponse> getAllPeople();

    public PersonResponse updatePerson(Long id,UpdatePersonRequest request);
}
