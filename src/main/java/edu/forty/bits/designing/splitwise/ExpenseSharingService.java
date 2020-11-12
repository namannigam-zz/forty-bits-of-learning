package edu.forty.bits.designing.splitwise;

import edu.forty.bits.designing.splitwise.exceptions.InvalidRequestException;
import edu.forty.bits.designing.splitwise.request.ExpenseRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExpenseSharingService {

    // amount owed from one user to another user
    Map<String, Map<String, Double>> lookupUserToUser;

    public ExpenseSharingService() {
        this.lookupUserToUser = new HashMap<>();
    }

    boolean createExpenses(ExpenseRequest expenseRequest) throws InvalidRequestException {
        validateRequestMeta(expenseRequest);
        String userWhoPaid = expenseRequest.getPayingUser();
        List<String> usersWhoOwe = expenseRequest.getUsers();
        Map<String, Double> userToAmountOwed = new HashMap<>();
        List<Double> shares = expenseRequest.getShareValues();
        List<Double> actualPriceShared = new ArrayList<>();
        switch (expenseRequest.getExpenseType()) {
            case EQUAL:
                double share = expenseRequest.getShareValues().get(0) / expenseRequest.getNumberOfUsers();
                actualPriceShared = IntStream.range(0, usersWhoOwe.size())
                        .mapToObj(i -> share)
                        .collect(Collectors.toList());
                return distributeExpenses(userWhoPaid, usersWhoOwe, userToAmountOwed, actualPriceShared);
            case EXACT:
                actualPriceShared = shares;
                return distributeExpenses(userWhoPaid, usersWhoOwe, userToAmountOwed, actualPriceShared);
            case PERCENT:
                for (Double percentage : expenseRequest.getShareValues()) {
                    actualPriceShared.add((percentage * expenseRequest.getTotalAmount()) / 100);
                }
                return distributeExpenses(userWhoPaid, usersWhoOwe, userToAmountOwed, actualPriceShared);
            default:
                throw new IllegalArgumentException("Invalid expense type!");
        }
    }

    private boolean distributeExpenses(String userWhoPaid, List<String> usersWhoOwe,
                                       Map<String, Double> userToAmountOwed,
                                       List<Double> shares) {
        for (int i = 0; i < shares.size(); i++) {
            userToAmountOwed.put(usersWhoOwe.get(i), shares.get(i));
        }

        for (String lookupUser : usersWhoOwe) {
            if (!lookupUser.equals(userWhoPaid)) {
                Map<String, Double> owingBalance = lookupUserToUser.getOrDefault(lookupUser, new HashMap<>());
                Double existingBalance = owingBalance.getOrDefault(userWhoPaid, 0.0);
                owingBalance.put(userWhoPaid, existingBalance + userToAmountOwed.get(lookupUser));
                lookupUserToUser.put(lookupUser, owingBalance);
            }
        }
        return true;
    }

    public Map<String, Map<String, Double>> showBalances() {
        return lookupUserToUser;
    }

    public Map<String, Double> showBalancePerUser(String userId) {
        return lookupUserToUser.getOrDefault(userId, new HashMap<>());
    }


    private void validateRequestMeta(ExpenseRequest expenseRequest) throws InvalidRequestException {

        // In case of percent, you need to verify if the total sum of percentage shares is 100 or not.
        // In case of exact, you need to verify if the total sum of shares is equal to the total amount or not.
    }
}