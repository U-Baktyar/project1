package org.example.controller;

import org.example.exception.ValidateException;
import org.example.model.user.Customer;
import org.example.validation.UserValidation;

import java.util.Scanner;

public class RegistrationCustomerController {
    private static volatile RegistrationCustomerController instance;

    public static RegistrationCustomerController getInstance() {
        if (instance == null) {
            synchronized (RegistrationCustomerController.class) {
                if (instance == null) {
                    instance = new RegistrationCustomerController(new Scanner(System.in), UserValidation.getInstance());
                }
            }
        }
        return instance;
    }
    private final Scanner scanner;
    private final UserValidation userValidation;
    private RegistrationCustomerController(Scanner scanner, UserValidation userValidation) {
        this.scanner = scanner;
        this.userValidation = userValidation;
    }

    public void registerCustomer() {
        System.out.print("Введите логин: ");
        String login =  scanner.nextLine();
        try {
            userValidation.checkLogin(login);
        } catch (ValidateException e){
            System.out.println(e.getMessage());
        }

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        try {
            userValidation.checkPassword(password);
        } catch (ValidateException e) {
            System.out.println(e.getMessage());;
        }

        System.out.print("Введите email: ");
        String email =  scanner.nextLine();

    }
}
