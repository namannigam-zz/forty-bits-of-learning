package edu.forty.bits.problemsolving.competitive.hackerearth.easy.may20;

import java.util.Scanner;

public class BracketSwapCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.next();
        System.out.println(swapCount(sequence));
    }


    static long swapCount(String s) {
        int countLeft = 0, countRight = 0;
        int swap = 0, imbalance = 0;
        for (char aChar : s.toCharArray()) {
            if (aChar == '(') {
                countLeft++;
                if (imbalance > 0) {
                    swap += imbalance;
                    imbalance--;
                }
            } else if (aChar == ')') {
                countRight++;
                imbalance = (countRight - countLeft);
            }
        }
        return swap;
    }
}