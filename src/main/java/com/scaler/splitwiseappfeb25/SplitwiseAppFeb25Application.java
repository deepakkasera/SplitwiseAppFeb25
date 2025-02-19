package com.scaler.splitwiseappfeb25;

import com.scaler.splitwiseappfeb25.commands.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseAppFeb25Application {
    @Autowired
    private static CommandExecutor commandExecutor;

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseAppFeb25Application.class, args);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            commandExecutor.executeCommand(input);
        }
    }
}
