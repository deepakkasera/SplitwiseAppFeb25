package com.scaler.splitwiseappfeb25.strategy;

import com.scaler.splitwiseappfeb25.models.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<Expense> settleUp(List<Expense> expenses);
}
