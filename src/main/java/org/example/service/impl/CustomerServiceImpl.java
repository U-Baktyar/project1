package org.example.service.impl;

import org.example.dao.CustomerDAO;
import org.example.dao.impl.CustomerDAOImpl;
import org.example.exception.UserNotFoundException;
import org.example.model.user.Customer;
import org.example.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private static volatile CustomerServiceImpl customerService;

    public static CustomerServiceImpl getInstance() {
        if (customerService == null) {
            synchronized (CustomerServiceImpl.class) {
                if (customerService == null) {
                    customerService = new CustomerServiceImpl(CustomerDAOImpl.getInstance());
                }
            }
        }
        return customerService;
    }

    private final CustomerDAO userDAO;

    private CustomerServiceImpl(CustomerDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean isCustomerExist(String login){
        try {
            this.getByLoginCustomer(login);
            return true;
        }catch (UserNotFoundException e){
            return false;
        }
    }

    @Override
    public Customer getByLoginCustomer(String login) throws UserNotFoundException {
        Customer user = userDAO.getByLogin(login);
        if (user == null) {
            throw new UserNotFoundException("Пользователь с логином " + login + " не найден");
        }
        return user;
    }
}
