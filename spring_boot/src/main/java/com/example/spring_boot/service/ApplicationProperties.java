package com.example.spring_boot.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Configuration
@ConfigurationProperties("app")
public class ApplicationProperties {

    public String locale;
    public Integer rightAnswersNumber;
    public Integer questionsNumber;
    public  MessageSource messageSource;


}
