package com.xym.datastructure.huawei;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        return getDividedSum(nums, 0, nums.length - 1);
    }

    private int getDividedSum(int[] arr, int l, int r) {
        if (l == r) return arr[l];
        if (l > r) return Integer.MIN_VALUE;
        int mid = (l + r) >> 1;
        int leftSum = getDividedSum(arr, l, mid);
        int rightSum = getDividedSum(arr, mid + 1, r);
        int lMax = Integer.MIN_VALUE, lSum = 0;
        for (int i = mid; i >= l; i--) {
            lSum = arr[i] + lSum;
            lMax = Math.max(lMax, lSum);
        }
        int rMax = Integer.MIN_VALUE, rSum = 0;
        for (int i = mid + 1; i <= r; i++) {
            rSum = arr[i] + rSum;
            rMax = Math.max(rMax, rSum);
        }
        return Math.max(Math.max(leftSum, rightSum), lMax + rMax);
    }
}
