package com.example.durian_assurance.dto.responses;

import com.example.durian_assurance.models.users.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
public class UserResponse {
    Long id;
    String name;
    String bankAccount;
    String address;
    String phone;
    String email;

    public static UserResponse toResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .bankAccount(user.getBankAccount())
                .address(user.getAddress())
                .email(user.getEmail())
                .build();
    }
}
