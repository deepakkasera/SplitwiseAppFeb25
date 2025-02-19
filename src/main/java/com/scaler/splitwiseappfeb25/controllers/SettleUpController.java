package com.scaler.splitwiseappfeb25.controllers;

import com.scaler.splitwiseappfeb25.dtos.SettleUpGroupRequestDto;
import com.scaler.splitwiseappfeb25.dtos.SettleUpGroupResponseDto;
import com.scaler.splitwiseappfeb25.dtos.SettleUpUserRequestDto;
import com.scaler.splitwiseappfeb25.dtos.SettleUpUserResponseDto;
import org.springframework.stereotype.Controller;

@Controller
public class SettleUpController {

    public SettleUpUserResponseDto settleUpUser(SettleUpUserRequestDto  requestDto) {
        return null;
    }

    public SettleUpGroupResponseDto settleUpGroup(SettleUpGroupRequestDto requestDto) {
        return null;
    }
}

/*

E1 -> 1000

A, B, C, D

A paid 500 Rs
B paid 500 Rs

A had to pay 250 Rs
B had to pay 250 Rs
C had to pay 250 Rs
D had to pay 250 Rs

Transactions :
Dummy Expense : C -> A : 250
D -> B : 250

Expense : 250
C paid 250
A had to 250
 */
