package com.scaler.splitwiseappfeb25.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "expenses")
public class Expense extends BaseModel {
    private int amount;
    private String description;

    @ManyToOne
    private User createdBy;

    @OneToMany
    private List<ExpenseUser> expenseUsers;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;
}

/*

Expense ------ CreatedBy => M:1


 */