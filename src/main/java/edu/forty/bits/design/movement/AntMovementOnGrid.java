package edu.forty.bits.design.movement;

/**
 * An ant is sitting on an infinite grid of white and black squares. It initially faces right. At
 * each step it does the following: 1. At a white square, flip the color of the square, turn 90
 * degrees right (clockwise) and move forward one unit. 2. At a black square, flip the color of the
 * square, turn 90 degrees left (counterclockwise) and move forward one unit. Write a program to
 * simulate the first K moves that the ant makes and print the final board as a grid. note that you
 * are not provided with the grid data structure. You must design it. The only input to the method
 * is K. You should print the final grid and return nothing.
 */
public class AntMovementOnGrid {

    public static void main(String[] args) {
        Board board = new Board();
//    Grid grid = new Grid();
        System.out.println(board.toString());
        for (int i = 0; i < 100; i++) {
            System.out.println("\n\n---- MOVE " + i + " ----");
            board.move();
            String bs = board.toString();
            System.out.println(bs);

            //      grid.move();
            //      String gs = grid.toString();
            //      System.out.println(gs);

            //      boolean equals = bs.equals(gs);
            //      System.out.println(equals);
        }
    }
}