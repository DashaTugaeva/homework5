package org.example.api;

import lombok.RequiredArgsConstructor;
import org.example.data.FileDataLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class DataLoaderApi {
    private final FileDataLoader fileDataLoader;

    @GetMapping("")
    public String getManual(){

        return "/load - Для загрузки данных из файла students.csv в БД \n" +
                "/academic_record/edit_grade - изменение оценки конкретного ученика \n" +
                "/academic_record/groups/{groupId}/students/avg_grade - получение средних оценок \n" +
                "/students/add_in_group - добавление ученика в класс";
    }

    @GetMapping("load")
    public String loadData() throws IOException {
        fileDataLoader.loadData();
        return "данные из файла students.csv загружены";
    }

}
