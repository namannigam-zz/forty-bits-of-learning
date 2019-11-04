package edu.forty.bits.ps.competitive.hackerearth.easy.august18;

import java.util.Scanner;

/**
 * Pikachu has recently learnt a new move . He knows he can work hard and convert it into a stronger move . Both the moves  and  contain the same number of letters.
 *
 * In a single day, Pikachu can increase any letter of move  by one, that is, in a single day, he can convert letter  to ,  to ,  to  and so on. He can also convert letter  to letter .
 *
 * Pikachu just realized he also has a hidden ability. It can help him increase any letter of move  by ,  that is, in a single day, he can convert letter  to letter ,  into ,  into  ,  into  and so on.
 *
 * Now Pikachu wants to know the minimum number of days in which he can convert the move  into move   ?
 *
 *
 * Constraints:
 *
 * s and t consists of uppercase English letters only
 * Input format:
 *
 * First line contains an integer , the length of strings  and
 * Second line contains com.stackoverflow.nullpointer.string  of length
 * Third line contains com.stackoverflow.nullpointer.string  of length
 */
public class PickachuGameOfStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        String t = scanner.next();
        System.out.println(countMoves(s, t, 0));
    }


    private static int countMoves(String s, String t, int moves) {
        for (int i = 0; i < s.length(); i++) {
            int diff = t.charAt(i) - s.charAt(i);
            if (diff < 0) {
                diff = 26 + diff;
            }
            if (diff >= 13) {
                moves = moves + 1;
            }
            moves = moves + (diff % 13);
        }
        return moves;
    }
}