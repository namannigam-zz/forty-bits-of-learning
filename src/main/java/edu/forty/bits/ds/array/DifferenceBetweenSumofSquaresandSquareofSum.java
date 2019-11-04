package edu.forty.bits.ds.array;

import java.util.stream.IntStream;

/**
 * @link
 *     {https://www.geeksforgeeks.org/difference-between-sum-of-the-squares-of-first-n-natural-numbers-and-square-of-sum}
 */
public class DifferenceBetweenSumofSquaresandSquareofSum {

  /**
   * @param range input for first n natural numbers
   * @return difference
   */
  public static int formulaBased(int range) {
    if (range == 1) {
      return 0;
    }
    // sum of the squares of the
    // first range natural numbers is
    int sumOfSquare = (range * (range + 1) * (2 * range + 1)) / 6;

    // sum of range naturals numbers
    int squareOfSum = (range * (range + 1)) / 2;

    // square of k
    squareOfSum = squareOfSum * squareOfSum;

    // Differences between sumOfSquares and k
    return Math.abs(sumOfSquare - squareOfSum);
  }

  public static int streamFormulation(int range) {
    int squareOfSum = (int) Math.pow(IntStream.rangeClosed(1, range).sum(), 2);
    int sumOfSquares = IntStream.rangeClosed(1, range).map(x -> (x * x)).sum();
    return squareOfSum - sumOfSquares;
  }
}
