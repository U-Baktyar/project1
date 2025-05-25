package org.example.factory;

import org.example.factory.impl.implCommand.GetProductCommand;
import org.example.factory.impl.implCommandFactory.ExitCommandCreate;
import org.example.factory.impl.implCommandFactory.GetProductCommandCreate;
import org.example.factory.impl.implCommandFactory.HelpCommandCreate;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {
    private static volatile CommandRegistry instance;

    public static CommandRegistry getInstance() {
        if (instance == null) {
            synchronized (CommandRegistry.class) {
                if (instance == null) {
                    instance = new CommandRegistry();
                    instance.register();
                }
            }
        }
        return instance;
    }


    private final Map<String, CommandFactory> commands = new HashMap<>();


    public CommandRegistry() {}


    private void register() {
        commands.put("exit", new ExitCommandCreate());
        commands.put("help", new HelpCommandCreate());
        commands.put("all_product", new GetProductCommandCreate());
    }

    public CommandFactory getCommandFactory(String commandName) {
        return commands.get(commandName);
    }

}
