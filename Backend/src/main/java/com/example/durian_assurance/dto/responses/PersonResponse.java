package com.example.durian_assurance.dto.responses;

import com.example.durian_assurance.models.Person;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
public class PersonResponse {
    Long id;
    String firstName;
    String lastName;
    String bankAccount;
    String address;
    String phone;
    String email;

    public static PersonResponse toPersonResponse(Person person){
        return PersonResponse.builder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .bankAccount(person.getBankAccount())
                .address(person.getAddress())
                .email(person.getEmail())
                .build();
    }
}
