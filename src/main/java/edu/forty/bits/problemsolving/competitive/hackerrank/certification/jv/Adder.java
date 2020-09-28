package edu.forty.bits.problemsolving.competitive.hackerrank.certification.jv;

import java.util.Scanner;

public class Adder {

    public static void main(String[] args) {
        int a, b;
        try (Scanner scan = new Scanner(System.in)) {
            a = scan.nextInt();
            b = scan.nextInt();
        }
        Calculator adderObject = new Added();
        System.out.println("The sum is: " + adderObject.add(a, b));
    }

    abstract static class Calculator {
        abstract int add(int a, int b);
    }

    static class Added extends Calculator {
        @Override
        int add(int a, int b) {
            return a + b;
        }
    }
}
