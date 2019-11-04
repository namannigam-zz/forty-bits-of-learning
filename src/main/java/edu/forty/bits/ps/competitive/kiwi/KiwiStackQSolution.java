package edu.forty.bits.ps.competitive.kiwi;

import java.util.Scanner;
import java.util.Stack;

public class KiwiStackQSolution {
  private static Stack<Integer> integerStack = new Stack<>();

  public static void main(String args[]) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    Scanner scanLines = new Scanner(System.in);
    int lines = scanLines.nextInt();

    for (int linesInText = 0; linesInText < lines; linesInText++) {
      String line = scanLines.nextLine();
      if (line.contains("push")) {
        String[] splitLines = line.split("\\s+");
        int valueToPush = Integer.parseInt(splitLines[1]);
        integerStack.push(valueToPush);
        System.out.println(integerStack.elementAt(integerStack.size() - 1));
      }
      if (line.contains("pop")) {
        integerStack.pop();
        if (integerStack.size() == 0) {
          System.out.println("EMPTY");
        } else {
          System.out.println(integerStack.elementAt(integerStack.size() - 1));
        }
      }
      if (line.contains("inc")) {
        String[] splitLines = line.split("\\s+");
        int bottomRange = Integer.parseInt(splitLines[1]);
        int incrementValue = Integer.parseInt(splitLines[2]);
        for (int index = integerStack.size() - 1;
            index > (integerStack.size() - 1 - bottomRange);
            index--) {
          int finalValue = integerStack.get(index) + incrementValue;
          integerStack.add(finalValue, index);
        }
        System.out.println(integerStack.elementAt(integerStack.size() - 1));
      }
    }
  }
}
