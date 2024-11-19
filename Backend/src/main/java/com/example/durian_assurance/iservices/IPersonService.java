package com.example.durian_assurance.iservices;

import com.example.durian_assurance.dto.requests.CreateUserRequest;
import com.example.durian_assurance.dto.requests.UpdateUserRequest;
import com.example.durian_assurance.dto.responses.UserResponse;

import java.util.List;

public interface IPersonService {
    public UserResponse createPerson(CreateUserRequest request);

    public UserResponse getPerson(Long id);

    public List<UserResponse> getAllPeople();

    public UserResponse updatePerson(Long id, UpdateUserRequest request);
}
