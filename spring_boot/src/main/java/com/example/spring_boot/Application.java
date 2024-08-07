package com.example.spring_boot;

import com.example.spring_boot.service.ApplicationProperties;
import com.example.spring_boot.service.TestingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        /*TestingService testingService = context.getBean(TestingService.class);
        testingService.testStudent();*/
    }


    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:questions");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

}
