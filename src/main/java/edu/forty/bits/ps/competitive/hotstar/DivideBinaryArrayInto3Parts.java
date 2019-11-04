package edu.forty.bits.ps.competitive.hotstar;

import java.util.Scanner;

public class DivideBinaryArrayInto3Parts {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        for (int i = 0;
             i < testCaseCount;
             i++) {
            int countOfNumbers = scanner.nextInt();
            int[] arr = new int[countOfNumbers];
            int [] lastValue = new int[countOfNumbers/3];
            int lastIndexOfOne = 0;
            int countOfOne = 0;

            for (int j = 0; j < countOfNumbers; j++) {
                int nextInt = scanner.nextInt();
                if (nextInt == 1) {
                    countOfOne++;
                    if (j > lastIndexOfOne) {
                        lastIndexOfOne = j;
                    }
                }
                arr[j] = nextInt;
            }
            if(countOfNumbers%3 == 0 && countOfOne == countOfNumbers) {
                System.out.println(Math.pow(2,(countOfNumbers/3)) -1);
            }
            if (countOfOne % 3 == 0) {
                if ((countOfNumbers - lastIndexOfOne) > (countOfNumbers / 3)) {
                    System.out.println("-1");
                } else {
                    System.out.println("pass");
                }
            } else {
                System.out.println("-1");
            }
        }
    }
}