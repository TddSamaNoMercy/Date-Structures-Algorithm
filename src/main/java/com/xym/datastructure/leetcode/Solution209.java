package com.xym.datastructure.leetcode;

class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = -1, sum = 0;
        int res = nums.length + 1;
        while (l < nums.length) {
            if (sum < s && r < nums.length - 1) {
                sum += nums[++r];
            } else if (sum >= s){
                res = Math.min(res, r - l + 1);
                sum -= nums[l++];
            } else
                l++;
        }
        return res == nums.length + 1 ? 0 : res;
    }
}
