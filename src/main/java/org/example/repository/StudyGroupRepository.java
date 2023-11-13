package org.example.repository;

import org.example.dto.AverageGrade;
import org.example.model.AcademicRecord;
import org.example.model.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudyGroupRepository extends JpaRepository<StudyGroup, Long> {
    @Query("""
        select new org.example.dto.AverageGrade(
            s.firstName,
            s.lastName,
            s.age,
            sg.name,
            AVG(ar.grade)
        )
         from StudyGroup sg
         join Student s
         on sg.id = s.studyGroup.id
         join AcademicRecord ar
         on s.id = ar.student.id
         join StudyPlan sp
         ON sp.id = ar.studyPlan.id
         where sg.name = :nameGroup
         group by s.firstName, s.lastName, s.age, sg.name
    """)
    List<AverageGrade> searchAverageGradeForStudentInGroup(@Param("nameGroup") String nameGroup);


}
