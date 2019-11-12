package edu.forty.bits.ds.array;

import java.util.Arrays;

/**
 * Given an NxN matrix, where each pixel in the image is 4 bytes. Write a method to rotate the image
 * by 90 degrees. Can this be achieved in place?
 */
public class RotateMatrix {

  // One way is to rotate each edge while copying the top first and then swapping.
  // But this requires O(N) extra space
  // Another way is to swap index by index
  // Both the solutions are O(n^2) and can't get better.
  void rotateMatrix(int[][] matrix) {
    // has to be a square matrix
    if (matrix.length <= 1 || matrix.length != matrix[0].length) return;
    int n = matrix.length;
    for (int layer = 0; layer < n / 2; layer++) {
      int last = n - 1 - layer;
      for (int i = layer; i < last; i++) {
        int top = matrix[layer][i]; // save top
        int updatedIndex = last - (i - layer);// i-layer is the offset
        // left to top
        matrix[layer][i] = matrix[updatedIndex][layer];

        // bottom to left
        matrix[updatedIndex][layer] = matrix[last][updatedIndex];

        // right to bottom
        matrix[last][updatedIndex] = matrix[i][last];

        // top to right
        matrix[i][last] = top;
      }
    }
  }
}