package com.xym.datastructure.leetcode;

//remove element whose value is equals val
class Solution27 {
    public int removeElement(int[] nums, int val) {
        int i = 0, n = nums.length;
        while (i < n) {
            if (nums[i] != val) {
                i++;
            } else {
                swap(i, n - 1, nums);
                n--;
            }
        }
        return n;
    }

    private void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}