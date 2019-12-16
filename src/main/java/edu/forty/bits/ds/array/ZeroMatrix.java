package edu.forty.bits.ds.array;

/**
 * Write an algorithm such that if an element in a MxN matrix is zero, its entire column and row are
 * set to be zero.
 */
public class ZeroMatrix {

    // traverse the first row and first column to store their states
    // while traversing the entire matrix, make the element of first row and column 0 accordingly
    // traverse first row and column again to nullify
    // nullify the first row and first column based on the flags set fom first iteration
    void setZerosInMatrix(int[][] matrix) {
        boolean rowHasZero = false;
        boolean columnHasZero = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                rowHasZero = true;
                break;
            }
        }

        for (int j = 0; j < matrix.length; j++) {
            if (matrix[j][0] == 0) {
                columnHasZero = true;
                break;
            }
        }

        // set the first element of the row and column as 0 for every such occurrence
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                nullifyRow(matrix, i);
            }
        }

        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                nullifyColumn(matrix, j);
            }
        }

        if (rowHasZero) nullifyRow(matrix, 0);
        if (columnHasZero) nullifyColumn(matrix, 0);
    }

    private void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    private void nullifyColumn(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}