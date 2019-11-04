package edu.forty.bits.ps.competitive.hackerearth.circuit.july18;

import java.util.Scanner;

/**
 * It is well-known that the equation: x^k + y^k = z^k has no positive solution for . But what if we
 * consider solution over a finite field. Now, the task you are given is related to that:
 *
 * <p>Given a prime , you are asked to count the number of positive integers doesn't exceed s.t.
 * modulo equation x^k + y^k = z^k (modulo P) has solution 0 < x, y, z < P .
 *
 * <p>Input Format
 *
 * <p>A line contains two space-separated integers as described above.
 *
 * <p>Output Format
 *
 * <p>Output answer in a single line.
 */
public class ModuloFermat {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int P = scanner.nextInt();
    long L = scanner.nextLong();
    int count = 0;
    for (long pow = 1; pow < L; pow++) {
      boolean flag = false;
      powerloop:
      for (int i = 1; i < P; i++) {
        for (int j = 1; j < P; j++) {
          for (int k = 1; k < P; k++) {
            if (equationHoldsTrue(i, j, k, pow, P)) {
              flag = true;
              break powerloop;
            }
          }
        }
      }
      if (flag) count++;
    }
    System.out.println(count);
  }

  private static boolean equationHoldsTrue(int x, int y, int z, long k, int P) {
    return (Math.pow(x, k) + Math.pow(y, k)) % P == (Math.pow(z, k) % P);
  }
}
