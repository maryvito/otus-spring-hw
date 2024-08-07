package com.example.spring_boot.service;

import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.util.Scanner;

@Service
public class ConsoleIOService {

    private final PrintStream out;
    private final Scanner sc;

    public ConsoleIOService() {
        this.out = System.out;
        this.sc = new Scanner(System.in);
    }

    public void out(String message){
        out.println(message);
    }

    public String readString(){
        return sc.nextLine();
    }
}
