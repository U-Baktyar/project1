package org.example.dao.impl;

import org.example.dao.ProductDAO;

import org.example.mapper.ProductALLMapper;
import org.example.model.product.Category;
import org.example.model.product.Product;
import org.example.utils.data.DBConnection;
import org.example.utils.data.impl.DBConnectionPSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductMapDAO implements ProductDAO {

    private static volatile ProductMapDAO instance;

    public static ProductMapDAO getInstance() {
        if (instance == null) {
            synchronized (ProductMapDAO.class) {
                if (instance == null) {
                    instance = new ProductMapDAO(DBConnectionPSQL.getInstance(), ProductALLMapper.getInstance());
                }
            }
        }
        return instance;
    }

    private final DBConnection dbConnection;
    private final ProductALLMapper productALLMapper;

    private ProductMapDAO(DBConnection dbConnection, ProductALLMapper productALLMapper) {
        this.dbConnection = dbConnection;
        this.productALLMapper = productALLMapper;
    }

    @Override
    public Map<String, List<Product>> findAllProducts() {
        Map<String, List<Product>> map = new HashMap<>();

        String sql = """
            SELECT c.name AS category_name,
                   p.id AS product_id,
                   p.name AS product_name,
                   p.price AS product_price,
                   p.volume AS product_volume
            FROM product p
            JOIN category c ON c.id = p.category_id
            """;

        try (
                Connection connection = dbConnection.getConnect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            while (resultSet.next()) {
                String categoryName = resultSet.getString("category_name");
                Product product = productALLMapper.mapRowToProduct(resultSet);
                map.computeIfAbsent(categoryName, k -> new ArrayList<>()).add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return map;
    }
}
