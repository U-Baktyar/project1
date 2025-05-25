package org.example.mapper;

import org.example.model.product.Product;
import org.example.model.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductALLMapper {
    private static volatile ProductALLMapper instance;

    public static ProductALLMapper getInstance() {
        if (instance == null) {
            synchronized (ProductALLMapper.class) {
                if (instance == null) {
                    instance = new ProductALLMapper();
                }
            }
        }
        return instance;
    }

    private ProductALLMapper() {}

    public Product mapRowToProduct(ResultSet resultSet) {
        Product product = new Product();
        try {
            product.setId(resultSet.getInt("product_id"));
            product.setName(resultSet.getString("product_name"));
            product.setPrice(resultSet.getDouble("product_price"));
            product.setVolume(resultSet.getString("product_volume"));
            return product;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
