package com.example.spring_boot.service;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Тест ConsoleIOService")
class ConsoleIOServiceTest {

    private static final String TEXT_TO_PRINT1 = "Ничто не истинно";
    private static final String TEXT_TO_PRINT2 = "Все дозволено";

    private PrintStream backup;
    private ByteArrayOutputStream bos;
    private ConsoleIOService ioService;

    @BeforeEach
    void setUp(){
        backup = System.out;
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        ioService = new ConsoleIOService();
    }

    @AfterEach
    void tearDown(){
        System.setOut(backup);
    }


    @DisplayName("должно печатать \"" + TEXT_TO_PRINT1 + "\"")
    @Test
    void shouldPrintOnlyFirstCreedLine(){
        ioService.out(TEXT_TO_PRINT1);
        assertThat(bos.toString()).isEqualTo(TEXT_TO_PRINT1 + System.lineSeparator());
    }
}