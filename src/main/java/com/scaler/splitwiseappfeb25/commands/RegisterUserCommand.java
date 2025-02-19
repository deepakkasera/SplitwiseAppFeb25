package com.scaler.splitwiseappfeb25.commands;

import com.scaler.splitwiseappfeb25.controllers.UserController;
import com.scaler.splitwiseappfeb25.dtos.SignUpRequestDto;
import com.scaler.splitwiseappfeb25.dtos.SignUpResponseDto;
import com.scaler.splitwiseappfeb25.models.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterUserCommand implements Command {
    //Register vinsmokesanji 003 namisswwaann
    private UserController userController;

    public RegisterUserCommand(UserController userController) {
        this.userController = userController;
    }

    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));

        return words.size() == 4 && words.get(0).equals(SupportedCommands.registerUserCommand);
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));
        String name = words.get(1);
        String phoneNumber = words.get(2);
        String password = words.get(3);

        SignUpRequestDto requestDto = new SignUpRequestDto();
        requestDto.setName(name);
        requestDto.setPhone(phoneNumber);
        requestDto.setPassword(password);

        SignUpResponseDto responseDto = userController.signUp(requestDto);
    }
}
