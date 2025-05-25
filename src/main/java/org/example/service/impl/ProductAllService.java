package org.example.service.impl;

import org.example.dao.ProductDAO;
import org.example.dao.impl.ProductMapDAO;
import org.example.exception.ProductNotFoundException;
import org.example.model.product.Product;
import org.example.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductAllService implements ProductService {
    private final ProductDAO productDAO;

    public ProductAllService() {
        this.productDAO = ProductMapDAO.getInstance();
    }

    @Override
    public Map<String, List<Product>> getAllProducts() throws ProductNotFoundException {
        Map<String, List<Product>> allProducts = productDAO.findAllProducts();
        if(allProducts.isEmpty()){
            throw new ProductNotFoundException("No products found");
        }
        return allProducts;
    }
}
