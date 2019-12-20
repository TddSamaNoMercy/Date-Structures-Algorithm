package com.xym.datastructure.leetcode;

//碰撞指针
class Solution11 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int res = 0;
        while (l < r) {
            res = Math.max(res, (r - l) * Math.min(height[l], height[r]));
            if (height[l] > height[r])
                r--;
            else
                l++;
        }
        return res;
    }

}