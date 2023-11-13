package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
public class AcademicRecordSearchAverageGrade {
    @NotBlank
    private String nameGroup;
}
