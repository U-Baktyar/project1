package org.example.runner;

import org.example.factory.Command;
import org.example.factory.CommandFactory;
import org.example.factory.CommandRegistry;

import java.util.Scanner;

public class Runner {
    private static volatile Runner instance;

    public static Runner getInstance() {
        if (instance == null) {
            synchronized (Runner.class) {
                if (instance == null) {
                    instance = new Runner();
                }
            }
        }
        return instance;
    }


    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("==== Дабро пажаловать Sat ====");
        CommandRegistry commandRegistry = CommandRegistry.getInstance();
        while (true) {
            String command = scanner.nextLine();
            CommandFactory commandFactory = commandRegistry.getCommandFactory(command);
            if (commandFactory != null) {
                Command commandAny = commandFactory.commandCreate();
                commandAny.command();
            }else {
                System.out.println("Команда не распознана.");
            }
        }
    }
}
