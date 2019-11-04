package edu.forty.bits.ps.competitive.hackerearth.circuit.july18;

import java.util.Scanner;

/**
 * Creatnx now wants to decorate his house by flower pots. He plans to buy exactly ones. He can only
 * buy them from Triracle's shop. There are only two kind of flower pots available in that shop. The
 * shop is very strange. If you buy flower pots of kind 1 then you must pay and if you buy flower
 * pots of kind 2. Please help Creatnx buys exactly flower pots that minimizes money he pays.
 *
 * <p>Input Format
 *
 * <p>The first line contains a integer denoting the number of test cases.
 *
 * <p>Each of test case is described in a single line containing three space-separated integers .
 *
 * <p>Output Format
 *
 * <p>For each test case, print a single line containing the answer.
 */
public class SpecialShop {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();

    for (int i = 0; i < T; i++) {
      long N = scanner.nextInt();
      long A = scanner.nextInt();
      long B = scanner.nextInt();

      if (A > B) {
        long temp = A;
        A = B;
        B = temp;
      }
      long criticalPoint = (long) (Math.round(A * N / ((float) (A + B))) - 1);
      long minValue = Long.MAX_VALUE;
      int count = 0;
      while (count < 3) {
        long remainingValue = N - criticalPoint;
        long currentMinValue =
            B * criticalPoint * criticalPoint + A * remainingValue * remainingValue;
        if (currentMinValue < minValue) {
          minValue = currentMinValue;
        }
        count++;
        criticalPoint++;
      }
      System.out.println(minValue);
    }
  }
}
