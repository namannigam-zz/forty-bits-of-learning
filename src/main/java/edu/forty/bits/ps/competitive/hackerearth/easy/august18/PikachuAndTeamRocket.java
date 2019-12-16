package edu.forty.bits.ps.competitive.hackerearth.easy.august18;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Team Rocket is back with of their Pokemon to trouble Pikachu. The Team Rocket's Pokemon are
 * numbered from to and the pokemon has health equal to
 *
 * <p>Pikachu has to battle multiple Pokemon simultaneously. In a single battle, Team Rocket will
 * make Pikachu fight against all the Pokemon in the range . Pikachu can defeat a Pokemon if his
 * attack value is atleast the Pokemon's health. So, he wants to know the minimum attack he must
 * have to defeat all Pokemon in the range.
 *
 * <p>However, this time, Team Rocket is stronger than ever. They have designed a technology to
 * modify their Pokemon's health as either of two ways:
 *
 * <p>Type 1: They choose some k (), and then health changes as ai = ai+1 () and aN = ak. Type 2:
 * They choose some k (), and then health changes as ai = ai-1 () and a1 = ak. Note that, all health
 * changes occur simultaneously.
 *
 * <p>There will be events. Each event will be either a battle, or some modification of Pokemon's
 * health by Team Rocket.
 *
 * <p>For each battle, help Pikachu by finding the minimum attack value he must have to win against
 * all Pokemon in the range.
 *
 * <p>Constraints:
 *
 * <p>In case of battling event, In case of modification event, Input format:
 *
 * <p>First line contains two space separated integers, and Second line contains initial health
 * values of Pokemon Nex lines contain one event each If the event is a battle, the line contains
 * where is the range of Pokemon. If the event is modification of type p (), the line contains where
 * is the index chosen by Team Rocket. Output format:
 *
 * <p>Output one line each for a battling event, containing the minimum attack value required to
 * defeat all Pokemon in the range.
 */
public class PikachuAndTeamRocket {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long arr[] = LongStream.range(0, n).map(i -> scanner.nextLong()).toArray();
        LongStream.range(0, k)
                .mapToObj(i -> IntStream.range(1, arr.length))
                .flatMapToInt(Function.identity())
                .forEach(j -> arr[j] = arr[j - 1] | arr[j]);
    }
}
