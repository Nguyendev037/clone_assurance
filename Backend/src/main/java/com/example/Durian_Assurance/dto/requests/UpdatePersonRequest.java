package com.example.Durian_Assurance.dto.requests;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class UpdatePersonRequest {
    String firstName;
    String lastName;
    String address;
    String phone;
    String email;
}
