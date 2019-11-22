package com.xym.datastructure.binarytree;


import java.util.HashMap;
import java.util.Map;

class Test {
    int a;

    Test(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                '}';
    }

    public static void main(String[] args) {
        Test t1 = new Test(1);
        Test t2 = new Test(2);
        Map<Test, Integer> map = new HashMap<>();
        map.put(t1, 1);
        map.put(t2, 2);


    }
}