package com.xym.datastructure.leetcode;

//合并两个有序数组 第一个数组大容量大于等于两个数组元素和
class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m - 1, r = n - 1;
        int cur = m + n - 1;
        while (l >= 0 && r >= 0) {
            nums1[cur--] = (nums1[l] > nums2[r]) ? nums1[l--] : nums2[r--];
        }
        System.arraycopy(nums2, 0, nums1, 0, r + 1);
    }
}