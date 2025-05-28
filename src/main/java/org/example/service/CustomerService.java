package org.example.service;

import org.example.exception.UserNotFoundException;
import org.example.model.user.Customer;

public interface CustomerService {
    boolean isCustomerExist(String login);
    Customer getByLoginCustomer(String login) throws UserNotFoundException;
}
