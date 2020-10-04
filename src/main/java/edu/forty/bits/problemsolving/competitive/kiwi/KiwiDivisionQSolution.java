package edu.forty.bits.problemsolving.competitive.kiwi;

import java.util.Scanner;

public class KiwiDivisionQSolution {

    public static void main(String[] args) {
        // write your code here
        long maxChocolates = 0;
        Scanner scanner = new Scanner(System.in);
        int totalCase = scanner.nextInt();
        for (int line = 0; line < totalCase; line++) {
            long cuts = scanner.nextLong();
            maxChocolates = (cuts / 2) * (cuts - (cuts / 2));
            System.out.println(maxChocolates);
        }
    }
}
