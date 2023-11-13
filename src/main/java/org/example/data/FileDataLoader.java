package org.example.data;

import lombok.RequiredArgsConstructor;
import org.example.model.AcademicRecord;
import org.example.model.Student;
import org.example.model.StudyGroup;
import org.example.model.StudyPlan;
import org.example.service.AcademicRecordService;
import org.example.service.StudentService;
import org.example.service.StudyGroupService;
import org.example.service.StudyPlanService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


@Service
@Transactional
@Validated
@RequiredArgsConstructor
public class FileDataLoader {
    private final StudyGroupService studyGroupService;
    private final StudyPlanService studyPlanService;
    private final StudentService studentService;
    private final AcademicRecordService academicRecordService;
    private String[] disciplines = {"физика", "математика", "русский", "литература", "геометрия", "информатика"};
    private String[] group = {"1", "2", "3", "4", "5", "6","7", "8", "9", "10", "11", "12"};

    public void loadStudyPlan() {
        for (int i = 0; i < disciplines.length; i++) {
            StudyPlan studyPlan = new StudyPlan();
            studyPlan.setName(disciplines[i]);
            studyPlanService.save(studyPlan);
        }
    }
    public void loadStudyGroup() {
        for (int i = 0; i < group.length; i++) {
            StudyGroup studyGroup = new StudyGroup();
            studyGroup.setName(group[i]);
            studyGroupService.save(studyGroup);
        }
    }
    public void loadData() throws IOException {
        loadStudyPlan();
        loadStudyGroup();
        BufferedReader reader = new BufferedReader(new FileReader("src/students.csv"));
        Scanner scanner = null;
        int index = 0;
        String line = reader.readLine();
        String firstName = null;
        String lastName = null;
        Integer age = 0;
        Long groupId = 1L;
        Long studentId = 1L;
        while ((line = reader.readLine()) != null) {
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                String data = scanner.next();
                switch (index) {
                    case 0:
                        firstName = data;
                        break;
                    case 1:
                        lastName = data;
                        break;
                    case 2:
                        age = Integer.parseInt(data);
                        break;
                    case 3:
                        groupId = Long.parseLong(data);
                        Student student = new Student(firstName, lastName, age);
                        student.setStudyGroup(studyGroupService.get(groupId));
                        studentService.save(student);
                        break;
                    case 4:
                        AcademicRecord academicRecord = new AcademicRecord();
                        academicRecord.setGrade(Integer.parseInt(data));
                        academicRecord.setStudent(studentService.get(studentId));
                        academicRecord.setStudyPlan(studyPlanService.get(1L));
                        academicRecordService.save(academicRecord);
                        break;
                    case 5:
                        academicRecord = new AcademicRecord();
                        academicRecord.setGrade(Integer.parseInt(data));
                        academicRecord.setStudent(studentService.get(studentId));
                        academicRecord.setStudyPlan(studyPlanService.get(2L));
                        academicRecordService.save(academicRecord);
                        break;
                    case 6:
                        academicRecord = new AcademicRecord();
                        academicRecord.setGrade(Integer.parseInt(data));
                        academicRecord.setStudent(studentService.get(studentId));
                        academicRecord.setStudyPlan(studyPlanService.get(3L));
                        academicRecordService.save(academicRecord);
                        break;
                    case 7:
                        academicRecord = new AcademicRecord();
                        academicRecord.setGrade(Integer.parseInt(data));
                        academicRecord.setStudent(studentService.get(studentId));
                        academicRecord.setStudyPlan(studyPlanService.get(4L));
                        academicRecordService.save(academicRecord);
                        break;
                    case 8:
                        academicRecord = new AcademicRecord();
                        academicRecord.setGrade(Integer.parseInt(data));
                        academicRecord.setStudent(studentService.get(studentId));
                        academicRecord.setStudyPlan(studyPlanService.get(5L));
                        academicRecordService.save(academicRecord);
                        break;
                    case 9:
                        academicRecord = new AcademicRecord();
                        academicRecord.setGrade(Integer.parseInt(data));
                        academicRecord.setStudent(studentService.get(studentId));
                        academicRecord.setStudyPlan(studyPlanService.get(6L));
                        academicRecordService.save(academicRecord);
                        break;
                }
                index++;
            }

            index = 0;
            studentId ++;
        }
        reader.close();
    }

}
