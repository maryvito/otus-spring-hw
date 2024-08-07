package ru.service;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Service;

import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CsvReader {

    public Map<String, List<String>> getQuestionsAndAnswers(String csvPath) throws Exception {

       Path path = Paths.get(
                    ClassLoader.getSystemResource(csvPath).toURI());

       List<String[]> allLines = readAllLines(path);
        Map<String, List<String>> result = new HashMap<>();

        for (String[] e: allLines) {
            List<String> answers = Arrays.asList(e).subList(1, e.length);
            result.put(e[0], answers);
        }

            return result;
        }

    public List<String[]> readAllLines(Path filePath) throws Exception {
        try (Reader reader = Files.newBufferedReader(filePath)) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                return csvReader.readAll();
            }
        }
    }

}
