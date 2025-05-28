package org.example.dao;

import org.example.model.user.Customer;

public interface CustomerDAO {
    public Customer getByLogin(String login);
}
