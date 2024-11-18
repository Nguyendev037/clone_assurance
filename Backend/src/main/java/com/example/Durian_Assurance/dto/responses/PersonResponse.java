package com.example.Durian_Assurance.dto.responses;

import com.example.Durian_Assurance.models.Person;
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
    String address;
    String phone;
    String email;

    public static PersonResponse toPersonResponse(Person person){
        return PersonResponse.builder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .address(person.getAddress())
                .email(person.getEmail())
                .build();
    }
}
