package com.scaler.splitwiseappfeb25.services;

import com.scaler.splitwiseappfeb25.exceptions.UserNotFoundException;
import com.scaler.splitwiseappfeb25.models.Expense;
import com.scaler.splitwiseappfeb25.models.ExpenseUser;
import com.scaler.splitwiseappfeb25.models.User;
import com.scaler.splitwiseappfeb25.repositories.ExpenseUserRepository;
import com.scaler.splitwiseappfeb25.repositories.UserRepository;
import com.scaler.splitwiseappfeb25.strategy.SettleUpStrategy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SettleUpService {
    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;
    private SettleUpStrategy settleUpStrategy;

    public SettleUpService(UserRepository userRepository,
                           ExpenseUserRepository expenseUserRepository,
                           SettleUpStrategy settleUpStrategy) {
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.settleUpStrategy = settleUpStrategy;
    }

    public List<Expense> settleUpUser(Long userId) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            //Invalid User
            throw new UserNotFoundException("User with id: " + userId + " doesn't exist.");
        }

        User user = optionalUser.get();

        // Fetch all the expenses in which the current user is present.
        List<ExpenseUser> expenseUsers = expenseUserRepository.findByUser(user);

        Set<Expense> expensesToSettle = new HashSet<>();
        for (ExpenseUser expenseUser : expenseUsers) {
            expensesToSettle.add(expenseUser.getExpense());
        }

        List<Expense> transactions = settleUpStrategy.settleUp(expensesToSettle.stream().toList());

        //Instead of returning all the transactions to the user, we can return the transactions
        // in which the current user is present.
        List<Expense> transactionsToReturn = new ArrayList<>();
        for (Expense expense : transactions) {
            for (ExpenseUser expenseUser : expense.getExpenseUsers()) {
                if (expenseUser.getUser().equals(user)) {
                    transactionsToReturn.add(expense);
                    break;
                }
            }
        }

        return transactionsToReturn;
    }

    public List<Expense> settleUpGroup(Long groupId) {
        return null;
    }
}

/**
 *
 * Expense - E1
 * User - U1
 *
 * E1U1 - paid - 500 Rs
 * E1U1 - hadToPay - 300 Rs
 *
 */


/*
E1
E2
E3
E4
E5


A -> B : 500
A -> D : 250
B -> E : 300
.......
......
......
 */
