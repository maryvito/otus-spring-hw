package com.example.spring_boot.shell;

import com.example.spring_boot.service.TestingService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
public class TestingCommands {

    public final TestingService testingService;

    public String userName;

    @ShellMethod(value = "Login command", key = {"l", "login"})
    public String login(@ShellOption(defaultValue = "AnyUser") String login){
        this.userName = login;
        return String.format("Добро пожаловать %s", userName);
    }

    @ShellMethod(value = "Testing", key = {"t", "test"})
    @ShellMethodAvailability(value = "isTestMethodAvailable")
    public String testStudent() throws Exception {
        testingService.testStudent();
        return "Тестирование окончено";
    }

    public Availability isTestMethodAvailable(){
        return userName == null ? Availability.unavailable("Сначала залогиньтесь") : Availability.available();
    }
}
