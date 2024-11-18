package com.example.Durian_Assurance.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GeneratorType;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="cases")

public class Case extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column
    String case_name;
    @Column
    String case_description;


}
