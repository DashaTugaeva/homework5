package org.example.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class StudentGrade {
    private final Long studentId;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String object;
    private final int grade;
}
