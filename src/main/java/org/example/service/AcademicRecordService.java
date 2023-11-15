package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.*;
import org.example.model.AcademicRecord;
import org.example.model.Student;
import org.example.repository.AcademicRecordRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Validated
@RequiredArgsConstructor
public class AcademicRecordService implements AcademicRecordDao {
    private final AcademicRecordRepository academicRecordRepository;
    private final StudentService studentService;
    @Override
    public List<AcademicRecord> getAll() {
        return academicRecordRepository.findAll();
    }

    @Override
    public AcademicRecord get(Long id) {
        return academicRecordRepository.findById(id).orElse(null);
    }

    @Override
    public AcademicRecord save(AcademicRecord object) {
        return academicRecordRepository.save(object);
    }

    @Override
    public void delete(Long id) {
        academicRecordRepository.delete(get(id));
    }

    public Long findByStudentIdAndObject(Long id, String nameObject) {
        return academicRecordRepository.findByStudentIdAndObject(id, nameObject);
    }
    public void editAverageGrade(Long id, int grade) {
        AcademicRecord academicRecord = get(id);
        academicRecord.setGrade(grade);
        save(academicRecord);
    }
}
