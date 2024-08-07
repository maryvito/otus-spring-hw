package ru.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.service.CsvReader;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@Log
public class CsvWriter {

    private final CsvReader csvReader;

    public void printQuestions(String path) throws Exception {
        Map<String, List<String>> questionsAndAnswers = csvReader.getQuestionsAndAnswers(path);
        questionsAndAnswers.entrySet().forEach(e -> System.out.println(e.getKey()));

    }


}
