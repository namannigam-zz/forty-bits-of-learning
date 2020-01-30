package edu.forty.bits.datastructures.bitops;

import java.util.Random;

/**
 * In the new post apocalypse world, the world queen is desperately concerned about the birth rate.
 * Therefore, she decides that all families should ensure that they have one girl or else they face massive fines.
 * If all families abide by this policy-that is, they continue to have children until they have one girl, at which
 * point they immediately stop. What will the gender ratio of the new generation be?
 */
public class Apocalypse {
    public static int[] runOneFamily() {
        Random random = new Random();
        int boys = 0;
        int girls = 0;
        while (girls == 0) { // until we have a girl
            if (random.nextBoolean()) { // girl
                girls += 1;
            } else { // boy
                boys += 1;
            }
        }
        return new int[]{girls, boys};
    }

    public static double runNFamilies(int n) {
        int boys = 0;
        int girls = 0;
        for (int i = 0; i < n; i++) {
            int[] genders = runOneFamily();
            girls += genders[0];
            boys += genders[1];
        }
        return girls / (double) (boys + girls);
    }

    public static void main(String[] args) {
        double ratio = runNFamilies(10000000);
        System.out.println(ratio);

    }
}