package org.example.controller;


import org.example.exception.ProductNotFoundException;
import org.example.model.product.Product;
import org.example.service.ProductService;
import org.example.service.impl.ProductAllService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductController {
    private static volatile ProductController instance;

    public static ProductController getInstance() {
        if (instance == null) {
            synchronized (ProductController.class) {
                if (instance == null) {
                    instance = new ProductController(new ProductAllService());
                }
            }
        }
        return instance;
    }

    private ProductService productService;
    private ProductController(ProductService productService) {
        this.productService = productService;
    }

    public void getAllProduct(){
        try {
            Map<String, List<Product>> products = productService.getAllProducts();

            for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
                System.out.println(entry.getKey());
                for (Product product : entry.getValue()) {
                    System.out.println(product.infoProduct());
                }
            }
        } catch (ProductNotFoundException e) {
            System.out.println("Продуктов нет");
        }

    }
}
