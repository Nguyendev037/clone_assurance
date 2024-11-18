package com.example.Durian_Assurance.iservices;

import com.example.Durian_Assurance.dto.requests.CreatePersonRequest;
import com.example.Durian_Assurance.dto.requests.UpdatePersonRequest;
import com.example.Durian_Assurance.dto.responses.PersonResponse;

import java.util.List;

public interface IPersonService {
    public PersonResponse createPerson(CreatePersonRequest request);

    public PersonResponse getPerson(Long id);

    public List<PersonResponse> getAllPeople();

    public PersonResponse updatePerson(Long id,UpdatePersonRequest request);
}
