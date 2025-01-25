package org.example.engineeringsocialnetwork.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Course {
    private String courseTitle;
    private String groupName;
    private LocalDate startDate;
    private LocalDate endDate;
}
