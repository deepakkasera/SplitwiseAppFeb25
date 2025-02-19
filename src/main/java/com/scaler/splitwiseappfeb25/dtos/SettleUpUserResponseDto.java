package com.scaler.splitwiseappfeb25.dtos;

import com.scaler.splitwiseappfeb25.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpUserResponseDto {
    private List<Expense> expenses; // == Transactions which needs to be executed to settle up the user.
}
