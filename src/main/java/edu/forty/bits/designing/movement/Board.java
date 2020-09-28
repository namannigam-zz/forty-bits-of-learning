package edu.forty.bits.designing.movement;

import java.util.HashSet;
import java.util.Set;

public class Board {

    private Set<Position> blackCells = new HashSet<>();
    private Ant ant = new Ant();
    private Position topLeftCorner = new Position(0, 0);
    private Position bottomRightCorner = new Position(0, 0);

    Board() {
    }

    // Move ant
    public void move() {
        ant.turn(isWhite(ant.position));
        // Turn clockwise on white, counter clockwise on black
        flip(ant.position); // flip
        ant.move(); // move
        ensureFit(ant.position);
    }

    /* Flip color of cells. */
    private void flip(Position position) {
        if (blackCells.contains(position)) {
            blackCells.remove(position);
        } else {
            blackCells.add(position.clone());
        }
    }

    /* "Grow" the grid by tracking the most top-left and bottom-right position that we've seen. */
    private void ensureFit(Position position) {
        int row = position.row;
        int column = position.column;

        topLeftCorner.row = Math.min(topLeftCorner.row, row);
        topLeftCorner.column = Math.min(topLeftCorner.column, column);

        bottomRightCorner.row = Math.max(bottomRightCorner.row, row);
        bottomRightCorner.column = Math.max(bottomRightCorner.column, column);
    }

    /* Check if cell is white. */
    private boolean isBlack(Position position) {
        return blackCells.contains(position);
    }

    private boolean isWhite(Position position) {
        return !isBlack(position);
    }

    /* Print board. */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int rowMin = topLeftCorner.row;
        int rowMax = bottomRightCorner.row;
        int colMin = topLeftCorner.column;
        int colMax = bottomRightCorner.column;
        for (int r = rowMin; r <= rowMax; r++) {
            for (int c = colMin; c <= colMax; c++) {
                if (r == ant.position.row && c == ant.position.column) {
                    sb.append(ant.orientation);
                } else if (isBlack(new Position(r, c))) {
                    sb.append("X");
                } else {
                    sb.append("_");
                }
            }
            sb.append("\n");
        }
        sb.append("Ant: ").append(ant.orientation).append(". \n");
        return sb.toString();
    }
}