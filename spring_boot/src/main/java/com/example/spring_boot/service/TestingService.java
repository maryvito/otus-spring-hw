package com.example.spring_boot.service;


import com.example.spring_boot.dao.QuestionsDao;
import com.example.spring_boot.entity.Task;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TestingService {


    private final MessageSource messageSource;
    public final ApplicationProperties props;
    public final QuestionsDao questionsDao;
    public final ConsoleIOService consoleIOService;


    public TestingService(MessageSource messageSource,
                          ApplicationProperties props,
                          QuestionsDao questionsDao,
                          ConsoleIOService consoleIOService) {
        this.messageSource = messageSource;
        this.props = props;
        this.questionsDao = questionsDao;
        this.consoleIOService = consoleIOService;
    }

    public void testStudent() throws Exception {

        int rightAnswers = 0;

        List<Task> questionsAndAnswers =
                questionsDao.getQuestionsAndAnswers();

        for (Task task : questionsAndAnswers) {
            System.out.println(task.getQuestion() + " " + task.getAnswers());
            String answer = consoleIOService.readString();
            if (answer.equals(task.getRightAnswer())) {
                rightAnswers++;
                consoleIOService.out("Верно!");
            } else consoleIOService.out("Неверно...");
        }

        if (rightAnswers >= props.rightAnswersNumber)
            consoleIOService.out("Вы выиграли!");
        else consoleIOService.out("Вы проиграли...");

    }


    public List<String> getQuestionAndAnswers(int i){
        String questionAndAnswers = messageSource.getMessage("q" + i, null, null,
                new Locale(props.locale));
        List<String> questionAndAnswersList = Arrays.asList(questionAndAnswers.split(","));
        return questionAndAnswersList;
    }
}
