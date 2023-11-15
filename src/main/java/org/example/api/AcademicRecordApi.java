package org.example.api;

import lombok.RequiredArgsConstructor;
import org.example.dto.*;
import org.example.service.AcademicRecordService;
import org.example.service.StudyGroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/academic_record")
public class AcademicRecordApi {
    private final AcademicRecordService academicRecordService;
    private final StudyGroupService studyGroupService;


    @GetMapping("groups/{groupId}/students/avg_grade")
    public SimpleResponse<List<AverageGrade>> search(@PathVariable Long groupId) {
        var result = studyGroupService.searchAverageGradeForStudentInGroup(groupId.toString());
        return new SimpleResponse<>(result);
    }


    @PostMapping("students/edit_grade")
    public void editGrade(@RequestBody StudentGradeEditByStudentId studentGrade) {
        System.out.println(studentGrade.getId() + " " + studentGrade.getNameObject() + " " + studentGrade.getGrade());
        Long id = academicRecordService.findByStudentIdAndObject(studentGrade.getId(), studentGrade.getNameObject());
        academicRecordService.editAverageGrade(id, studentGrade.getGrade());
    }

}
