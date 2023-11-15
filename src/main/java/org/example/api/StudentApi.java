package org.example.api;

import lombok.RequiredArgsConstructor;
import org.example.dto.*;
import org.example.service.AcademicRecordService;
import org.example.service.StudentService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentApi {
    private final StudentService studentService;
    private final AcademicRecordService academicRecordService;

    @PostMapping("/add_in_group")
    public void addStudent(@RequestBody StudentAddInGroup student) {
        studentService.add(student);
    }

    @PostMapping("/{studentId}/academic_record/grade")
    public void editGrade(@PathVariable Long studentId,
                          @RequestBody StudentGradeEditByStudentId studentGrade) {
        Long id = academicRecordService.findByStudentIdAndObject(studentId, studentGrade.getNameObject());
        academicRecordService.editAverageGrade(id, studentGrade.getGrade());
    }


}
