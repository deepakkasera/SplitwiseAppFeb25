package com.scaler.splitwiseappfeb25.commands;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddGroupCommand implements Command {
    //u1 AddGroup Roommates

    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));

        return words.size() == 3 && words.get(1).equals(SupportedCommands.addGroupCommand);
    }

    @Override
    public void execute(String input) {
        //groupController.createGroup(requestDto);
    }
}
