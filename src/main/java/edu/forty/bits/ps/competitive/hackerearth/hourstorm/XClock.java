package edu.forty.bits.ps.competitive.hackerearth.hourstorm;

import java.util.Scanner;

public class XClock {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int x = scanner.nextInt();
        int a = Integer.parseInt("" + str.charAt(0));
        int b = Integer.parseInt("" + str.charAt(1));
        int c = Integer.parseInt("" + str.charAt(3));
        int d = Integer.parseInt("" + str.charAt(4));
        int sum = a + b + c + d;
//        int mod = sum % x;
//        System.out.println(mod == 0 ? 0 : x - mod);

        int cnt = 0;
        int min = (c * 10) + d;
        int hr = (a * 10) + b;

        if ((a + b + c + d) % x == 0) {
            System.out.println("0");
        } else {
            while (hr < 24) { // max hour representation
                if (min > 60) { // max min representation
                    hr++;
                    min = 0; // reset
                }
                min++;
                cnt++;
                int p = min % 10;
                int q = (min / 10) % 10;
                int r = hr % 10;
                int s = (hr / 10) % 10;

                if ((p + q + r + s) % x == 0) {
                    System.out.println(cnt);
                    break;
                }

            }
        }
    }
}