package com.xym.datastructure.DynamicProgramming;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.get(0) == null)
            return 0;
        int size = triangle.size();
        for (int i = size-2; i >=0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int num = triangle.get(i).get(j);
                int n = Math.min(triangle.get(i + 1).get(j) , triangle.get(i + 1).get(j + 1) )+ num;
                triangle.get(i).set(j, n);
            }
        }
        return triangle.get(0).get(0);
    }


    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(2);
        List<Integer> l2 = Arrays.asList(3, 4);
        List<Integer> l3 = Arrays.asList(6, 5, 7);
        List<Integer> l4 = Arrays.asList(4, 1, 8, 3);

        List<List<Integer>> triangle = Arrays.asList(l1, l2, l3, l4);
        System.out.println(minimumTotal(triangle));

    }
}
