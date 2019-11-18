package edu.forty.bits.design.movement;

public enum Orientation {
  LEFT,
  UP,
  RIGHT,
  DOWN;

  public Orientation getTurn(boolean clockwise) {
    if (this == LEFT) {
      return clockwise ? UP : DOWN;
    } else if (this == UP) {
      return clockwise ? RIGHT : LEFT;
    } else if (this == RIGHT) {
      return clockwise ? DOWN : UP;
    } else {
      return clockwise ? LEFT : RIGHT;
    }
  }

  @Override
  public String toString() {
    if (this == LEFT) {
      return "\u2190";
    } else if (this == UP) {
      return "\u2191";
    } else if (this == RIGHT) {
      return "\u2192";
    } else {
      return "\u2193";
    }
  }
}