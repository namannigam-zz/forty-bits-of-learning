package edu.forty.bits.ps.competitive.capillary;

import java.util.Scanner;

/**
 * Let's define Old number as a number , such that it is divisible by count of odd integers in the range  to . If number does not hold this property, then such number is defined as Cold number.
 * You are given an array  and  tasks of the form  , you have to find what is the minimum numbers of steps needed to make subarray from  to  balanced.
 * Any subarray is said to be balanced if count of Old number(s) is not less than count of Cold number(s) in that subarray. In every step, you can either increase the value of some array element by 1 or you can decrease an array element by 1.
 *
 * Note: All tasks are independent of each other.
 *
 * Input Format:
 * First line contains an integer , denoting the number of testcases.
 *
 * In each test case:
 * Firstl line contains , the number of elements in array .
 * Next line contains  space separated integers denoting array elements.
 * Next line contains , the number of queries.
 * Each of the next  lines contains two space separated integers  and .
 *
 * Output Fomat:
 * For each task, print total number of steps needed to change the subarray such that subarray from  to  is balanced.
 * Answer for each task should be printed in a new line.
 */
public class OldAndColdNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int i = 0; i < T; i++) {
            int N = scanner.nextInt(); // array size
            int[] arr = new int[N];
            for(int j = 0; j < N; j++) {
                arr[j] = scanner.nextInt();
            }
            int Q = scanner.nextInt(); // queries

            for(int k = 0; k < Q; k++) {
                int L = scanner.nextInt();
                int R = scanner.nextInt();
                int countColdNumber = 0;
                for(int m = L - 1; m < R; m++) {
                    if (arr[m] == 1 || arr[m] % 2 == 0) {
                        countColdNumber--;
                    } else {
                        countColdNumber++;
                    }
                }

                if (countColdNumber > 0) {
                    System.out.println(0);
                    if (countColdNumber % 2 == 0) {
                        System.out.println(countColdNumber / 2);
                    } else {
                        System.out.println((countColdNumber / 2) + 1);
                    }
                }
            }
        }
    }
}