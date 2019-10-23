package org.practice.learning.competitive.wynk;

public class SqrtTest {

    public static void main(String[] args) {
        int i, k, j = 1;
        for (i = 0; i < 5; i++) {
            k = j++ + ++j;
            System.out.println(k + " ");
        }
        double x = -9.0;
        System.out.println(Math.sqrt(x));

        try {
            int a = 0;
            int y = 5 / a;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("finish");
        Outer.Inner.foo();

    }
}