package edu.forty.bits.designing.movement;

public class Ant {
    Position position = new Position(0, 0);
    Orientation orientation = Orientation.RIGHT; // starting position

    void turn(boolean clockwise) {
        orientation = orientation.getTurn(clockwise);
    }

    public void move() {
        if (orientation == Orientation.LEFT) {
            position.column--;
        } else if (orientation == Orientation.RIGHT) {
            position.column++;
        } else if (orientation == Orientation.UP) {
            position.row--;
        } else if (orientation == Orientation.DOWN) {
            position.row++;
        }
    }

    void adjustPosition(int shiftRow, int shiftColumn) {
        position.row += shiftRow;
        position.column += shiftColumn;
    }
}