package com.example.spring_boot.dao;

import com.example.spring_boot.entity.Task;
import com.example.spring_boot.service.ApplicationProperties;
import com.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
@RequiredArgsConstructor
public class QuestionsDao {

    public final MessageSource messageSource;
    public final ApplicationProperties props;

    public List<Task> getQuestionsAndAnswers() throws Exception {

        List<Task> result = new ArrayList<>();

        String resourcePath = messageSource.getMessage("questions.path", null, null,
                new Locale(props.locale));


        Path path = Paths.get(
                ClassLoader.getSystemResource(resourcePath).toURI());

        List<String[]> allLines = readAllLines(path);

        for (String[] e: allLines) {
            List<String> allItems = Arrays.asList(e);
            Task task = new Task();
            task.setQuestion(allItems.get(0));
            task.setAnswers(allItems.subList(1, allItems.size() - 2));
            task.setRightAnswer(allItems.get(allItems.size() - 1));
        }

        return result;
    }

    public List<String[]> readAllLines(Path path) throws Exception {
        try (Reader reader = Files.newBufferedReader(path)) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                return csvReader.readAll();
            }
        }
    }
}
