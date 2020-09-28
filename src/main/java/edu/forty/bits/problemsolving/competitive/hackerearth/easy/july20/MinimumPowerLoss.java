package edu.forty.bits.problemsolving.competitive.hackerearth.easy.july20;


import java.util.Scanner;

public class MinimumPowerLoss {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] evilBuildings = new int[d];
        int power = 0;
        for (int i = 0; i < d; i++) {
            int currentEvil = scanner.nextInt();
            evilBuildings[i] = currentEvil;
            if (Math.abs(x - currentEvil) < Math.abs(y - currentEvil)) {
                power = power + Math.abs(x - currentEvil);
                x = currentEvil;
            } else {
                power = power + Math.abs(y - currentEvil);
                y = currentEvil;
            }
        }
        System.out.println(power);
    }

}