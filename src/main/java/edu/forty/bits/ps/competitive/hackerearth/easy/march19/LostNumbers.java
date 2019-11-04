package edu.forty.bits.ps.competitive.hackerearth.easy.march19;

import java.util.Scanner;

public class LostNumbers {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int AorB = scanner.nextInt();
    int AandB = scanner.nextInt();
    int AxorB = scanner.nextInt();
  }

  static void compute(long S, long X) {
    long A = (S - X) / 2;
    int a = 0, b = 0;
    final int LONG_FIELD_SIZE = 8;

    // Traverse through all bits
    for (int i = 0; i < 8 * LONG_FIELD_SIZE; i++) {
      long Xi = (X & (1 << i));
      long Ai = (A & (1 << i));
      if (Xi == 0 && Ai == 0) {
        // Let us leave bits as 0.
      } else if (Xi == 0 && Ai > 0) {
        a = ((1 << i) | a);
        b = ((1 << i) | b);
      } else if (Xi > 0 && Ai == 0) {
        a = ((1 << i) | a);

        // We leave i-th bit of b as 0.
      } else // (Xi == 1 && Ai == 1)
      {
        System.out.println(-1);
      }
    }

    System.out.println("a = " + a + "\nb = " + b);
  }
}
