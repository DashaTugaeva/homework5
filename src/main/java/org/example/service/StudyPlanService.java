package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.StudyPlanDao;
import org.example.model.StudyPlan;
import org.example.repository.StudyPlanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Transactional
@Validated
@RequiredArgsConstructor
public class StudyPlanService implements StudyPlanDao {
    private final StudyPlanRepository studyPlanRepository;
    @Override
    public List<StudyPlan> getAll() {
        return studyPlanRepository.findAll();
    }

    @Override
    public StudyPlan get(Long id) {
        return studyPlanRepository.findById(id).orElse(null);
    }

    @Override
    public StudyPlan save(StudyPlan object) {
        return studyPlanRepository.save(object);
    }

    @Override
    public void delete(Long id) {
        studyPlanRepository.delete(get(id));
    }
}
