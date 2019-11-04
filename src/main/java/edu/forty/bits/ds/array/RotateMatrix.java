package edu.forty.bits.ds.array;

import java.util.Arrays;

// rotate a matrix of NxN   (possible to do this in place?)
public class RotateMatrix {

    // one way is to rotate each edge while copying the top first and then swapping, but this requires O(N) extra space
    // another is to swap index by index
    // both the solutions are O(n^2) and can't get better
    private static void rotateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return;
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int last = n - 1 - layer;
            for (int i = layer; i < last; i++) {
                int offset = i - layer;
                int top = matrix[layer][i]; // save top

                // left to top
                matrix[layer][i] = matrix[last - offset][layer];

                // bottom to left
                matrix[last - offset][layer] = matrix[last][last - offset];

                // right to bottom
                matrix[last][last - offset] = matrix[i][last];

                // top to right
                matrix[i][last] = top;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}