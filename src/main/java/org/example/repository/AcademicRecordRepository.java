package org.example.repository;

import org.example.model.AcademicRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AcademicRecordRepository extends JpaRepository<AcademicRecord, Long> {

    @Query("""
        select ar.id
         from Student s
         join AcademicRecord ar
         on s.id = ar.student.id
         join StudyPlan sp
         ON sp.id = ar.studyPlan.id
         where s.id = :id and sp.name = :nameObject
    """)
    Long findByStudentIdAndObject(@Param("id") Long id, @Param("nameObject") String nameObject);

}
