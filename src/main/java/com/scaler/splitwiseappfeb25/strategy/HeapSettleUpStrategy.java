package com.scaler.splitwiseappfeb25.strategy;

import com.scaler.splitwiseappfeb25.models.Expense;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HeapSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Expense> settleUp(List<Expense> expenses) {
        //TODO: Implement Min and Max Heap approach to settleUp. Refer Design Splitwise notes for the algorithm.
        return null;
    }
}
