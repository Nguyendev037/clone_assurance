package com.example.durian_assurance.dto.requests;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class UpdateUserRequest {
    String name;
    String address;
    String phone;
    String email;
}
