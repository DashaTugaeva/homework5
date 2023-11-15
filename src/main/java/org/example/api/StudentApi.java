package org.example.api;

import lombok.RequiredArgsConstructor;
import org.example.dto.*;
import org.example.service.StudentService;
import org.example.service.StudyGroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentApi {
    private final StudentService studentService;

    @PostMapping("/add_in_group")
    public void addStudent(@RequestBody StudentAddInGroup student) {
        studentService.add(student);
    }


}
