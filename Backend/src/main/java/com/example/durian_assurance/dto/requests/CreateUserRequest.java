package com.example.durian_assurance.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class CreateUserRequest {
    @NotBlank(message = "Name must not be blank")
    String name;
    @NotBlank(message = "Bank Account must not be be blank")
    String bankAccount;
    String address;
    String phone;
    String email;
}
