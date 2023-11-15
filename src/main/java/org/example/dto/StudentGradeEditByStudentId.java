package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class StudentGradeEditByStudentId {

    @NotBlank
    private String nameObject;

    @NotBlank
    private int grade;
}
