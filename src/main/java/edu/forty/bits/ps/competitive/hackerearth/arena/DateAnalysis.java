package org.practice.learning.competitive.hackerearth.arena;

import java.util.Scanner;

public class DateAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 0; i < T; i++) {
            String d1 = scanner.next();
            String d2 = scanner.next();

            int startYear = Integer.parseInt(d1.split(":")[2]);
            int endYear = Integer.parseInt(d2.split(":")[2]);

            // every year there would be just one lucky date
            int count = 0;
            for(int j = startYear; j <= endYear; j++) {
                if (j % 100 > 13 || j % 100 < 3) continue;
                int mm = (j % 100) - 1;
                int dd = mm - 1;
                if (j == startYear) {
                    if (mm < Integer.parseInt(d1.split(":")[1])) {
                        continue;
                    }
                    if (mm == Integer.parseInt(d1.split(":")[1]) && dd < Integer.parseInt(d1.split(":")[0])) {
                        continue;
                    }
                }
                if (j == endYear) {
                    if (mm > Integer.parseInt(d2.split(":")[1])) {
                        continue;
                    }
                    if (mm == Integer.parseInt(d2.split(":")[1]) && dd > Integer.parseInt(d2.split(":")[0])) {
                        continue;
                    }
                }
                count++;
            }
            System.out.println(count);
        }
    }
}