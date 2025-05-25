package org.example.service;

import org.example.exception.ProductNotFoundException;
import org.example.model.product.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    public Map<String, List<Product>> getAllProducts() throws ProductNotFoundException;
}
