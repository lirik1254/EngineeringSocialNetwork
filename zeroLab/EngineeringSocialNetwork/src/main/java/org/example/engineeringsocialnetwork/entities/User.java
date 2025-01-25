package org.example.engineeringsocialnetwork.entities;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    private int age;
    private String role;
    private String city;
    private String status;
    private LocalDate registeredAt;
}
