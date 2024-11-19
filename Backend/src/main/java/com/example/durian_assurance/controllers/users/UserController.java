package com.example.durian_assurance.controllers.users;

import com.example.durian_assurance.dto.requests.CreateUserRequest;
import com.example.durian_assurance.dto.requests.UpdateUserRequest;
import com.example.durian_assurance.dto.responses.UserResponse;
import com.example.durian_assurance.services.users.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createPerson(@RequestBody CreateUserRequest request){
        return userService.createPerson(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getPerson(@PathVariable(value = "id")Long id){
        return userService.getPerson(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getPeople(){
        return userService.getAllPeople();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse updatePerson(@PathVariable(value = "id")Long id, @RequestBody UpdateUserRequest request){
        return userService.updatePerson(id,request);
    }
}
