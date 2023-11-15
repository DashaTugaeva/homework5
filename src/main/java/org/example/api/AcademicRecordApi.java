package org.example.api;

import lombok.RequiredArgsConstructor;
import org.example.dto.*;
import org.example.service.StudyGroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/academic_record")
public class AcademicRecordApi {
    private final StudyGroupService studyGroupService;


    @GetMapping("groups/{groupId}/students/avg_grade")
    public SimpleResponse<List<AverageGrade>> search(@PathVariable Long groupId) {
        var result = studyGroupService.searchAverageGradeForStudentInGroup(groupId);
        return new SimpleResponse<>(result);
    }



}
