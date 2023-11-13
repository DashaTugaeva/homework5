package org.example.api;

import lombok.RequiredArgsConstructor;
import org.example.dto.AcademicRecordSearchAverageGrade;
import org.example.dto.AverageGrade;
import org.example.dto.SimpleResponse;
import org.example.service.StudyGroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentApi {

    private final StudyGroupService studyGroupService;

    @GetMapping("/average_grade")
    public SimpleResponse<List<AverageGrade>> search(@RequestBody AcademicRecordSearchAverageGrade nameGroup) {
        var result = studyGroupService.searchAverageGradeForStudentInGroup(nameGroup.getNameGroup());
        return new SimpleResponse<>(result);
    }

}
