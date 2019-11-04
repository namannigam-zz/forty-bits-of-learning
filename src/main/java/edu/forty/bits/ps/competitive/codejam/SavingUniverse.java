package edu.forty.bits.ps.competitive.codejam;

import java.util.Scanner;
import java.util.stream.IntStream;

public class SavingUniverse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = scanner.nextInt();
        IntStream.rangeClosed(1, T).forEach(t -> {
            Integer D = scanner.nextInt();
            String instruction = scanner.next();
            if (instruction.chars().filter(num -> num == 'S').count() > D) {
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + result(instruction, D));
            }
        });
    }

    private static String result(String instruction, Integer strength) {
        if (damageStrengthOfInstruction(instruction) <= strength) {
            return "0";
        }
        int count = 0;
        while (instruction.contains("CS")) {
            int t = instruction.lastIndexOf("CS");

            StringBuilder temp = new StringBuilder(instruction);
            temp.replace(t, t + 2, "SC");
            instruction = temp.toString();
            count++;
            if (damageStrengthOfInstruction(instruction) <= strength) {
                return String.valueOf(count);
            }
        }
        return "IMPOSSIBLE";
    }

    private static Integer damageStrengthOfInstruction(String instruction) {
        final Integer[] strength = {1};
        final Integer[] damage = {0};
        instruction.chars().forEach(c -> {
            if (c == 'S') {
                damage[0] = damage[0] + strength[0];
            }
            if (c == 'C') {
                strength[0] *= 2;
            }
        });
        return damage[0];
    }
}