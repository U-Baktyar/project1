package org.example.dao.impl;

import org.example.dao.CustomerDAO;
import org.example.mapper.CustomerMapper;
import org.example.model.user.Customer;
import org.example.utils.data.DBConnection;
import org.example.utils.data.impl.DBConnectionPSQL;

import java.sql.*;

public class CustomerDAOImpl implements CustomerDAO {
    private static volatile CustomerDAOImpl instance;

    public static CustomerDAOImpl getInstance() {
        if (instance == null) {
            synchronized (CustomerDAOImpl.class) {
                if (instance == null) {
                    instance = new CustomerDAOImpl(DBConnectionPSQL.getInstance(), CustomerMapper.getInstance());
                }
            }
        }
        return instance;
    }

    private final DBConnection dbConnection;
    private final CustomerMapper customerMapper;

    private CustomerDAOImpl(DBConnection dbConnection, CustomerMapper customerMapper) {
        this.dbConnection = dbConnection;
        this.customerMapper = customerMapper;
    }


    @Override
    public Customer getByLogin(String login) {
        Customer customer = null;
        String sql = "select * from customers where login = ?";
        try(
                Connection connection = dbConnection.getConnect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ) {
            preparedStatement.setString(1, login);
            try(ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    customer = customerMapper.mapRowToUser(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }
}
