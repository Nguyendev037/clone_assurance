package com.example.durian_assurance.services.users;

import com.example.durian_assurance.dto.requests.CreateUserRequest;
import com.example.durian_assurance.dto.requests.UpdateUserRequest;
import com.example.durian_assurance.dto.responses.UserResponse;
import com.example.durian_assurance.exceptions.NotFoundException;
import com.example.durian_assurance.iservices.IPersonService;
import com.example.durian_assurance.models.users.User;
import com.example.durian_assurance.repositories.users.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class UserService implements IPersonService {
    UserRepository userRepository;

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(()->new NotFoundException("Person with id " + id + " not found"));
    }

    @Override
    public UserResponse createPerson(CreateUserRequest request) {
        User user = User.builder()
                .name(request.getName())
                .bankAccount(request.getBankAccount())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build();
        userRepository.save(user);
        return UserResponse.toResponse(user);
    }

    @Override
    public UserResponse getPerson(Long id) {
        return UserResponse.toResponse(findById(id));
    }

    @Override
    public List<UserResponse> getAllPeople() {
        return userRepository.findAll().stream().map(UserResponse::toResponse).toList();
    }

    @Override
    public UserResponse updatePerson(Long id, UpdateUserRequest request) {
        User user = findById(id);
        user.setName(request.getName());
        user.setAddress(request.getAddress());
        user.setPhone(request.getPhone());

        userRepository.save(user);
        return UserResponse.toResponse(user);
    }
}
