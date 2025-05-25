package org.example.factory.impl.implCommand;

import org.example.controller.ExitController;
import org.example.factory.Command;

public class ExitCommand implements Command {
    private ExitController exitController;

    public ExitCommand(ExitController exitController) {
        this.exitController = exitController;
    }

    @Override
    public void command() {
        exitController.exit();
    }
}
