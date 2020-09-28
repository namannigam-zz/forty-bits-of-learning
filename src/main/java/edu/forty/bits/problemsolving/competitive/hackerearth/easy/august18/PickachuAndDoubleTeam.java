package edu.forty.bits.problemsolving.competitive.hackerearth.easy.august18;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Pikachu is battling against Meowth in the finals of Orange League. The battle is going to be held
 * on a circular battlefield with centre at point and radius The Meowth has learnt the move, Double
 * Team. Double team is a move which is used to create illusionary copies of the Pokemon.
 *
 * <p>Meowth has just used the Double Team and now there are Meowths which Pikachu has to fight.
 * Pikachu doesn't know the exact position of all the Meowths but he knows that the Meowth is
 * somewhere in the circle centred at point and of radius . Pikachu wants to win the battle and thus
 * he wants to use thundershock on the battlefield so that at least one Meowth get damaged. However,
 * he doesn't want to waste much energy, so he will not use thundershock on the whole battlefield,
 * but only in the area where atleast one Meowth can be present. Help Pikachu in calculating the
 * area he will have to cover?
 *
 * <p>Note that there it is impossible for a Meowth to be out of the battlefield.
 *
 * <p>Constraints:
 *
 * <p>It is guaranteed that all (xi,yi) are distinct and lie inside the battlefield. Input format:
 *
 * <p>First line contains integers, Next lines contain 3 integers each, of which contains . Output
 * format:
 *
 * <p>Print a real number, denoting the area Pikachu will have to cover. The solution will be marked
 * correct if the the absolute error or relative error is at most .
 */
public class PickachuAndDoubleTeam {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int r = scanner.nextInt();

        List<XYR> xyrList =
                IntStream.range(0, n)
                        .mapToObj(i -> new XYR(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()))
                        .collect(Collectors.toList());
    }

    private static class XYR {
        int x;
        int y;
        int r;

        public XYR(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
}
