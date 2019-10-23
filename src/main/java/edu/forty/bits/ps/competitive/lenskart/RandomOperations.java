package org.practice.learning.competitive.lenskart;

import java.util.*;

/**
 * Created by naman.nigam on 08/10/16.
 */
public class RandomOperations {

    static List<Character> operators = Arrays.asList('-', '+', '*', '/');
    static List<Character> operands = Arrays.asList('0', '1', '2', '3');
    static Set<String> testCases = new HashSet<>();
    public static void main(String args[]) {
        while (testCases.size() < 50) {
            String operand = getRandomOperand(operands);
            String operator = getRandomOperand(operators);
            String expression = operand + operator + operand;
            testCases.add(expression);

            if(expression.length()<10) {
                System.out.println(expression);
            }
        }
    }

    public static String getRandomOperator(List<Character> operators) {
        return operators.get(new Random().nextInt(operators.size())).toString();
    }

    private static String getRandomOperand(List<Character> operands) {
        return operands.get(new Random().nextInt(operands.size())).toString();
    }

}