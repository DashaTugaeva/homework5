package org.example.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class AverageGrade {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String groupName;
    private final double avg;
}
