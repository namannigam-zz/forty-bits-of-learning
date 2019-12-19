package edu.forty.bits.problemsolving.competitive.hackerearth.circuit.april19;

import java.util.Scanner;

public class GridAndPhrase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String lookup = "saba";
        int count = 0;
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            if (str.contains(lookup)) count++;
            if (m >= 0) System.arraycopy(scanner.next().toCharArray(), 0, grid[i], 0, m);
        }
        System.out.println(findPath(grid, lookup));
    }

    public static int findPath(char[][] map, String target) {
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                count += findPath(map, target, i, j, 0);
            }
        }
        return count;
    }

    private static int findPath(
            char[][] map, String target, int startX, int startY, int targetIndex) {
        if (startX < 0 || startY < 0 || startX >= map.length || startY >= map[startX].length) {
            return 0;
        }

        char original = map[startX][startY];

        if (original != target.charAt(targetIndex)) {
            return 0;
        }

        if (targetIndex == target.length() - 1) {
            return 1;
        }
        int count = 0;
        count += findPath(map, target, startX + 1, startY + 1, targetIndex + 1);
        count += findPath(map, target, startX + 1, startY, targetIndex + 1);
        count += findPath(map, target, startX - 1, startY + 1, targetIndex + 1);
        return count;
    }
}
