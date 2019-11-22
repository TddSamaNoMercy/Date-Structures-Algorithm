package com.xym.datastructure.sort;


public class ShellSort implements Sort {
    //最坏复杂度O(n^(4/3)),平均复杂度O(n^(7/6))
    int[] shell = {1, 5, 19, 41, 109, 209, 505, 929, 2161, 3905, 8929};

    @Override
    public int[] sort(int[] arr) {
        int n = arr.length;
        int index= shell.length -1;
        while (index >= 0) {
            int h = shell[index];
            for (int i = h; i < n; i++) {
                int num = arr[i];
                int j = i;
                //注意判断条件 num < arr[j-h]而不是arr[j] arr[j-h]
                //这层循环找到插入位置 并且将插入位置之后的元素右移一位
                for (; j >= h && num < arr[j - h]; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = num;
            }
            index--;
        }
        return arr;
    }


}
