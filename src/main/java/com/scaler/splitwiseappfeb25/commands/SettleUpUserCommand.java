package com.scaler.splitwiseappfeb25.commands;

import com.scaler.splitwiseappfeb25.controllers.SettleUpController;
import com.scaler.splitwiseappfeb25.dtos.SettleUpUserRequestDto;
import com.scaler.splitwiseappfeb25.dtos.SettleUpUserResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpUserCommand implements Command {
    //u1 SettleUp
    private SettleUpController settleUpController;

    public SettleUpUserCommand(SettleUpController settleUpController) {
        this.settleUpController = settleUpController;
    }

    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));

        return words.size() == 2 && words.get(1).equals(SupportedCommands.settleUpUserCommand);
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));
        Long userId = Long.valueOf(words.get(0));

        SettleUpUserRequestDto requestDto = new SettleUpUserRequestDto();
        requestDto.setUserId(userId);

        SettleUpUserResponseDto responseDto = settleUpController.settleUpUser(requestDto);
    }
}
