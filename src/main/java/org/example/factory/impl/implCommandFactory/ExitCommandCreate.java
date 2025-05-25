package org.example.factory.impl.implCommandFactory;

import org.example.controller.ExitController;
import org.example.factory.Command;
import org.example.factory.CommandFactory;
import org.example.factory.impl.implCommand.ExitCommand;

public class ExitCommandCreate implements CommandFactory {

    @Override
    public Command commandCreate() {
        return new ExitCommand(ExitController.getInstance());
    }
}
