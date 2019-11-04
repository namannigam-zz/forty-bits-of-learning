package edu.forty.bits.ps.competitive.wissen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Aligning the rectangles
 * You are given  rectangles each with length  and breadth . Now you have to arrange them in non-decreasing order of their lengths. If length of two rectangles is same then the one with the largest area should be placed first. Print the final arrangement of the rectangles.
 *
 * Input
 * First line contains an integer  as input denoting total number of rectangles.
 * Next  lines contain two space separated integers each denoting length and breadth of the subsequent rectangles.
 *
 * Output
 * In the output you need to print  lines where each line contains the length and breadth of the rectangle as they would look in the final arrangement according to the conditions given above.
 */
public class RectangleAligning {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Rectangle> rectangles = new ArrayList<>(N);
        for(int i = 0; i < N; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            rectangles.add(new Rectangle(Integer.parseInt(tk.nextToken()), Integer.parseInt(tk.nextToken())));
        }
        List<Rectangle> rectangleList = align_rectangle(rectangles);
        rectangleList.forEach(a -> System.out.println(a.getLength() + " " + a.getBreadth()));
    }

    private static List<Rectangle> align_rectangle(List<Rectangle> rectangles) {
        Comparator<Rectangle> lengthComparator = Comparator.comparing(Rectangle::getLength);
        Comparator<Rectangle> breadthComparator = Collections.reverseOrder(Comparator.comparing(Rectangle::getBreadth));
        rectangles.sort(lengthComparator.thenComparing(breadthComparator));
        return rectangles;
    }

    private static class Rectangle {
        int length;
        int breadth;

        Rectangle(int length, int breadth) {
            this.length = length;
            this.breadth = breadth;
        }

        public int getLength() {
            return length;
        }

        int getBreadth() {
            return breadth;
        }
    }
}