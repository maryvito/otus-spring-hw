package com.example.spring_boot;

import com.example.spring_boot.service.TestingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тесты тестирования ")
@SpringBootTest
class ApplicationTests {

    @Autowired
    public com.example.spring_boot.service.TestingService testingService;

    @DisplayName("должны возвращать правильную строку")
    @Test
    void contextLoads() {
        String q1 = "сколько вам лет?";
        List<String> qq1 = testingService.getQuestionAndAnswers(1);
        assertThat(qq1.get(0)).isEqualTo(q1);
    }

}
