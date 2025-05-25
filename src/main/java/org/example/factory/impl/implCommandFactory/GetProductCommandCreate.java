package org.example.factory.impl.implCommandFactory;

import org.example.controller.ProductController;
import org.example.factory.Command;
import org.example.factory.CommandFactory;
import org.example.factory.impl.implCommand.GetProductCommand;

public class GetProductCommandCreate implements CommandFactory {
    @Override
    public Command commandCreate() {
        return new GetProductCommand(ProductController.getInstance());
    }
}
