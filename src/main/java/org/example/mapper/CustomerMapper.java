package org.example.mapper;

import org.example.dao.CustomerDAO;
import org.example.dao.impl.CustomerDAOImpl;
import org.example.model.user.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper {
    private static volatile CustomerMapper userMapper;
    public static CustomerMapper getInstance() {
        if (userMapper == null) {
            synchronized (CustomerMapper.class) {
                if (userMapper == null) {
                    userMapper = new CustomerMapper(CustomerDAOImpl.getInstance());
                }
            }
        }
        return userMapper;
    }

    private final CustomerDAO userDAO;

    private CustomerMapper(CustomerDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Customer mapRowToUser(ResultSet resultSet){
        Customer customer = new Customer();
        try {
            customer.setId(resultSet.getInt("id"));
            customer.setLogin(resultSet.getString("login"));
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }
}
