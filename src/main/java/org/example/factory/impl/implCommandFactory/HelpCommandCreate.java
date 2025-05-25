package org.example.factory.impl.implCommandFactory;

import org.example.factory.Command;
import org.example.factory.CommandFactory;
import org.example.factory.impl.implCommand.HelpCommand;

public class HelpCommandCreate implements CommandFactory {
    @Override
    public Command commandCreate() {
        return new HelpCommand();
    }
}
