package org.example.factory.impl.implCommand;

import org.example.factory.Command;

public class HelpCommand implements Command {
    @Override
    public void command() {
        System.out.println("exit - выход из системы");
        System.out.println("help - вывод списка комманд");
        System.out.println("all_products - покозать все продукты");
    }
}
