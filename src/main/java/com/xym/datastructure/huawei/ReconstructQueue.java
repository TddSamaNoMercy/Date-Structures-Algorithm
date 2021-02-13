package com.xym.datastructure.huawei;

import java.util.Arrays;
import java.util.Comparator;

public class ReconstructQueue {
    public static int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return o1[0] - o2[0];
                else
                    return o2[1] - o1[1];
            }
        });
        int[][] ans = new int[n][];
        for (int[] person : people) {
            int blank = person[1] + 1;
            for (int i = 0; i < n; i++) {
                if (ans[i] == null)
                    blank--;
                if (blank == 0) {
                    ans[i] = person;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reconstructQueue(new int[][]{

                {5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}
        })));
    }
}
