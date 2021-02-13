package com.xym.datastructure.DynamicProgramming;

public class Test {
    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();
        fib(50);
        long l2 = System.currentTimeMillis();
        System.out.println("time: " + (l2 - l1));
    }

    private static int fib(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        return fib(i - 1) + fib(i - 2);
    }
}
