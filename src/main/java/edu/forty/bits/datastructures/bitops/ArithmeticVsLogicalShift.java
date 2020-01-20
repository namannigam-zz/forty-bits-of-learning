package edu.forty.bits.datastructures.bitops;

public class ArithmeticVsLogicalShift {
    public static void main(String[] args) {
        System.out.println(repeatedArithmeticShift(93242, 5));
        System.out.println(repeatedArithmeticShift(-93242, 40));
        System.out.println(repeatedLogicalShift(93242, 40));
        System.out.println(repeatedLogicalShift(-93242, 2));
    }

    static int repeatedArithmeticShift(int num, int count) {
        for (int i = 0; i < count; i++) {
            num >>= 1;
        }
        return num;
    }

    static int repeatedLogicalShift(int num, int count) {
        for (int i = 0; i < count; i++) {
            num >>>= 1;
        }
        return num;
    }

    static boolean getBit(int num, int i) {
        return ((num & (1 << i)) != 0);
    }

    static int setBit(int num, int i) {
        return num | (1 << i);
    }

    static int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }

    static int updateBit(int num, int i, int v) {
        int clearNum = clearBit(num, i);
        int mask = v << i;
        return clearNum | mask;
    }
}