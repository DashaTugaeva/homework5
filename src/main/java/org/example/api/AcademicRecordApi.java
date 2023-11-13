package org.example.api;

import lombok.RequiredArgsConstructor;
import org.example.dto.*;
import org.example.service.AcademicRecordService;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("/academic_record")
public class AcademicRecordApi {
    private final AcademicRecordService academicRecordService;

    @PostMapping("/edit_grade")
    public String editGrade(@RequestBody StudentGradeEditByStudentId studentGrade) {
        System.out.println(studentGrade.getId() + " " + studentGrade.getNameObject() + " " + studentGrade.getGrade());
        Long id = academicRecordService.findByStudentIdAndObject(studentGrade.getId(), studentGrade.getNameObject());
        int oldGrade = academicRecordService.editAverageGrade(id, studentGrade.getGrade());
        return "оценка студента c id:" + studentGrade.getId() +
                " по предмету:" + studentGrade.getNameObject() +
                " с оценки:" + oldGrade + " успешно изменина на оценку:" + studentGrade.getGrade();
    }

}
