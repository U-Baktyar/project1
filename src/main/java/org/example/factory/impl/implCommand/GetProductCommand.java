package org.example.factory.impl.implCommand;

import org.example.controller.ProductController;
import org.example.factory.Command;

public class GetProductCommand implements Command {
    private final ProductController productController;

    public GetProductCommand(ProductController productController) {
        this.productController = productController;
    }
    @Override
    public void command() {
        productController.getAllProducts();
    }
}
