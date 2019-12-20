package com.xym.datastructure.leetcode;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] != nums[k]) {
                nums[k++] = nums[i];
            }
        return k;
    }
}




