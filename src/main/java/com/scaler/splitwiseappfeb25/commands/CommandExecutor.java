package com.scaler.splitwiseappfeb25.commands;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {
    private SettleUpUserCommand settleUpUserCommand;
    private RegisterUserCommand registerUserCommand;
    private AddGroupCommand addGroupCommand;

    private List<Command> commands;

    public CommandExecutor(SettleUpUserCommand settleUpUserCommand,
                           RegisterUserCommand registerUserCommand,
                           AddGroupCommand addGroupCommand) {
        this.settleUpUserCommand = settleUpUserCommand;
        this.registerUserCommand = registerUserCommand;
        this.addGroupCommand = addGroupCommand;

        commands = new ArrayList<>();
        commands.add(settleUpUserCommand);
        commands.add(registerUserCommand);
        commands.add(addGroupCommand);
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void removeCommand(Command command) {
        commands.remove(command);
    }

    public void executeCommand(String input) {
        for (Command command : commands) {
            if (command.matches(input)) {
                command.execute(input);
                break;
            }
        }
    }
}
