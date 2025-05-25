package org.example.dao;
import org.example.model.product.Product;

import java.util.List;
import java.util.Map;

public interface ProductDAO {
    Map<String, List<Product>> findAllProducts();

}
