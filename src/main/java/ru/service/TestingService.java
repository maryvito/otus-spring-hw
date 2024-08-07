package ru.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Service
public class TestingService {

    private final String questionsFilePath;
    private final Integer rightAnswersNumber;
    private final CsvReader csvReader;

    public TestingService(@Value("${questions.file.path}") String questionsFilePath,
                          @Value("${right.answers.number}") Integer rightAnswersNumber,
                          CsvReader csvReader) {
        this.questionsFilePath = questionsFilePath;
        this.rightAnswersNumber = rightAnswersNumber;
        this.csvReader = csvReader;
    }

    public void testStudent() throws Exception {

        int rightAnswers = 0;

        Map<String, List<String>> questionsAndAnswers = csvReader.getQuestionsAndAnswers(questionsFilePath);

        try (Scanner scanner = new Scanner(System.in)) {

            for (Map.Entry<String, List<String>> entry : questionsAndAnswers.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue().subList(0, entry.getValue().size() - 1));
                String answer = scanner.next();
                String rightAnswer = entry.getValue().get(entry.getValue().size() - 1);
                if (answer.equals(rightAnswer)) {
                    rightAnswers++;
                    System.out.println("Верно!");
                } else System.out.println("Неверно...");
            }

            if (rightAnswers >= rightAnswersNumber)
                System.out.println("Вы выиграли!");
            else System.out.println("Вы проиграли...");
        }

    }
}
