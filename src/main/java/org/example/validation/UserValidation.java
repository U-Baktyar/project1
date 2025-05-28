package org.example.validation;


import org.example.exception.ValidateException;
import org.example.service.CustomerService;
import org.example.service.impl.CustomerServiceImpl;

import java.util.HashSet;
import java.util.Set;

public class UserValidation {
    private static volatile UserValidation instance;

    public static UserValidation getInstance() {
        if (instance == null) {
            synchronized (UserValidation.class) {
                if (instance == null) {
                    instance = new UserValidation(CustomerServiceImpl.getInstance());
                }
            }
        }
        return instance;
    }
    private CustomerService customerService;
    private UserValidation(CustomerService customerService) {
        this.customerService = customerService;
    }


    public void checkLogin(String login) throws ValidateException {
        if (login == null || login.trim().isEmpty()) {
            throw new ValidateException("Логин не может быть пустым");
        }

        login = login.trim();

        if (login.length() < 4 || login.length() > 20) {
            throw new ValidateException("Логин должен быть от 4 до 20 символов");
        }

        if (login.contains(" ")) {
            throw new ValidateException("Логин не должен содержать пробелы");
        }

        Set<String> stopWords = new HashSet<>(Set.of("sudo", "admin", "root"));
        if (stopWords.contains(login.toLowerCase())) {
            throw new ValidateException("Логин зарезервирован системой как ключевое слово, выберите другой логин");
        }

        if(customerService.isCustomerExist(login)){
            throw new ValidateException("Пользователь с таким логином уже зарегистрирован. Выберите другой логин.");
        }
    }

    public void checkPassword(String password) throws ValidateException {
        if (password == null || password.trim().isEmpty()) {
            throw new ValidateException("Пароль не может быть пустым");
        }

        password = password.trim();

        if (password.length() <= 8 || password.length() >= 20) {
            throw new ValidateException("Пароль должен быть от 8 до 20 символов");
        }

        if (password.contains(" ")) {
            throw new ValidateException("Пароль не должен содержать пробелы");
        }
    }

    public void checkEmail(String email) throws ValidateException {
        if (email == null || email.trim().isEmpty()) {
            throw new ValidateException("Email не может быть пустым");
        }
        email = email.trim();

        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        if (!email.matches(emailRegex)) {
            throw new ValidateException("Некорректный формат email");
        }

    }

}

