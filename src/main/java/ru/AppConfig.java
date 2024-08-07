package ru;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.service.CsvWriter;
import ru.service.TestingService;

@ComponentScan
@Configuration
@PropertySource("application.properties")
public class AppConfig {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        TestingService testingService = context.getBean(TestingService.class);
        testingService.testStudent();

    }
}
