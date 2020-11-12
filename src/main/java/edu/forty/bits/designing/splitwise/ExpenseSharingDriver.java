package edu.forty.bits.designing.splitwise;

import edu.forty.bits.designing.splitwise.entities.User;
import edu.forty.bits.designing.splitwise.exceptions.InvalidRequestException;
import edu.forty.bits.designing.splitwise.request.ExpenseRequest;
import edu.forty.bits.designing.splitwise.request.ExpenseType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExpenseSharingDriver {


    public static void main(String[] args) throws InvalidRequestException {
        ExpenseSharingService expenseSharingService = new ExpenseSharingService();
        List<User> users = Arrays.asList(
                new User("user1.esc", "user1", "rauser1@gmail", "mobileNumber1"),
                new User("user2.esc", "user2", "rauser2@gmail", "mobileNumber2"),
                new User("user3.esc", "user3", "rauser3@gmail", "mobileNumber3"),
                new User("user4.esc", "user4", "rauser4@gmail", "mobileNumber4"),
                new User("user5.esc", "user5", "rauser5@gmail", "mobileNumber5")
        );

        ExpenseRequest expenseRequest = createExpenseRequest("");
//        expenseSharingService.createExpenses(expenseRequest);


        expenseSharingService.createExpenses(new ExpenseRequest(
                "user5.esc", 4, 100, ExpenseType.EXACT,
                Arrays.asList("user5.esc", "user3.esc", "user2.esc", "user1.esc"),
                Arrays.asList(24.00, 28.00, 30.00, 18.00)
        ));

        expenseSharingService.createExpenses(new ExpenseRequest(
                "user5.esc", 5, 350, ExpenseType.EXACT,
                Arrays.asList("user5.esc", "user3.esc", "user2.esc", "user1.esc", "user4.esc"),
                Arrays.asList(00.00, 128.00, 100.00, 102.00, 20.00)
        ));

        Map<String, Map<String, Double>> stringMapMap = expenseSharingService.showBalances();
        System.out.println(stringMapMap);

        String userId = "user5.esc";
        Map<String, Double> stringDoubleMap = expenseSharingService.showBalancePerUser(userId);
        System.out.println(stringDoubleMap);

//        String userId = "user5.esc";
//        Map<String, Double> stringDoubleMap = expenseSharingService.showBalancePerUser(userId);
//        System.out.println(stringDoubleMap);
    }

    static ExpenseRequest createExpenseRequest(String input) {
        return null;
    }
}
