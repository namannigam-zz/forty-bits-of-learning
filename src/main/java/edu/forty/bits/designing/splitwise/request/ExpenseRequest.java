package edu.forty.bits.designing.splitwise.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ExpenseRequest {
    String payingUser;
    int numberOfUsers;
    double totalAmount;
    ExpenseType expenseType;
    // same size lists for exact and percentage
    List<String> users;
    List<Double> shareValues; // exact amount or shares as a list
}
