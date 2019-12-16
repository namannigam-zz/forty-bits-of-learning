package edu.forty.bits.design.movement;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Position {
    int row;
    int column;

    public Position clone() {
        return new Position(row, column);
    }
}