package org.example.repository;

import org.example.model.StudyPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyPlanRepository extends JpaRepository<StudyPlan, Long> {
}
