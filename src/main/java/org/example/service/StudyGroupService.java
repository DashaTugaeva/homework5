package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.AverageGrade;
import org.example.dto.StudyGroupDao;
import org.example.model.StudyGroup;
import org.example.repository.StudyGroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Transactional
@Validated
@RequiredArgsConstructor
public class StudyGroupService implements StudyGroupDao {
    private final StudyGroupRepository studyGroupRepository;
    @Override
    public List<StudyGroup> getAll() {
        return studyGroupRepository.findAll();
    }

    @Override
    public StudyGroup get(Long id) {
        return studyGroupRepository.findById(id).orElse(null);
    }

    @Override
    public StudyGroup save(StudyGroup object) {
        return studyGroupRepository.save(object);
    }

    @Override
    public void delete(Long id) {
        studyGroupRepository.delete(get(id));
    }

    public List<AverageGrade> searchAverageGradeForStudentInGroup(String query) {
        return studyGroupRepository.searchAverageGradeForStudentInGroup(query);
    }
}
