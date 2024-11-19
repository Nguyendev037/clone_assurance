package com.example.durian_assurance.dto.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class CreatePersonRequest {
    String firstName;
    String lastName;
    @NotNull
    String bankAccount;
    String address;
    String phone;
    String email;
}
