package com.example.spring_boot.entity;

import lombok.Data;

import java.util.List;

@Data
public class Task {

    private String question;

    private List<String> answers;

    private String rightAnswer;
}
