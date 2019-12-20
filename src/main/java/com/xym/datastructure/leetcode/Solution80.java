package com.xym.datastructure.leetcode;

//保留至多两个重复元素
class Solution80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int k = 0;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] != nums[k]) {
                nums[++k] = nums[i];
            } else if (k == 0 || nums[k] != nums[k - 1]) {
                nums[++k] = nums[i];
            }
        return k + 1;
    }
}