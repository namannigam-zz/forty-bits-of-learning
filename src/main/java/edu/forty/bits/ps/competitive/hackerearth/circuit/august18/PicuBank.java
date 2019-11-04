package edu.forty.bits.ps.competitive.hackerearth.circuit.august18;

import java.util.Scanner;

/**
 * You have dollars with you. You want to put it into a Bank, namely Picu Bank. This bank has a
 * peculiar behavior for interest. Regardless of the Bank deposit amount, every month it adds
 * dollars to your bank account and this continues till months. Exaxtly on months, it adds dollars
 * to your bank account. This scanario repeats again in same manner.( i.e on the month dollars are
 * added, and so on.. ). Your task is to find out how many months does it take for the dollar amount
 * to reach at least , in the bank account .
 *
 * <p>Input:
 *
 * <p>Input starts with an integer , denoting the number of test cases. Each case starts with 5
 * integers , and as described in problem statement.
 *
 * <p>Constraints:
 *
 * <p>Output:
 *
 * <p>For each case of input minimum number of months needed to reach dollar value of at least X in
 * a single line.
 *
 * <p>Note that the Expected Output feature of Custom Invocation is not supported for this contest.
 */
public class PicuBank {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    for (int t = 0; t < T; t++) {
      int D = scanner.nextInt();
      int A = scanner.nextInt();
      int M = scanner.nextInt();
      int B = scanner.nextInt();
      int X = scanner.nextInt();

      System.out.println(returnMonthCount(M, A, B, X - D));

      //            int inHandCash = D;
      //            int countMonth = 0;
      //            while (inHandCash < X) {
      //                for (int i = 0; i < M; i++) {
      //                    if (inHandCash < X) {
      //                        inHandCash = inHandCash + A;
      //                        countMonth++;
      //                    } else {
      //                        break;
      //                    }
      //                }
      //                if (inHandCash < X) {
      //                    inHandCash = inHandCash + B;
      //                    countMonth++;
      //                }
      //            }
      //
      //
      //            System.out.println(countMonth);
    }
  }

  private static int returnMonthCount(int M, int A, int B, int diff) { // diff = X-D
    int costForM1Month = (A * M) + B;
    int countMonth = diff / costForM1Month;
    int remaining = diff % costForM1Month;
    int additionalMonths;
    if (remaining % A == 0) {
      additionalMonths = remaining / A;
    } else {
      additionalMonths = (remaining / A) + 1;
    }
    return (countMonth * (M + 1)) + additionalMonths;
  }
}
