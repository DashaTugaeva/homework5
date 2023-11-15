package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.StudentAddInGroup;
import org.example.dto.StudentDao;
import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Service
@Transactional
@Validated
@RequiredArgsConstructor
public class StudentService implements StudentDao {
    private final StudentRepository studentRepository;
    private final StudyGroupService studyGroupService;

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student get(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student save(Student object) {
        return studentRepository.save(object);
    }

    @Override
    public void delete(Long id) {
        studentRepository.delete(get(id));
    }

    public void add(StudentAddInGroup studentAdd) {
        Student student = new Student();
        student.setFirstName(studentAdd.getFirstName());
        student.setLastName(studentAdd.getLastName());
        student.setAge(studentAdd.getAge());
        student.setStudyGroup(studyGroupService.findByName(studentAdd.getGroupName()));
        save(student);
    }
}
