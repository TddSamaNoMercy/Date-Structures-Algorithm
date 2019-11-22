package com.xym.datastructure.leetcode;


class Solution4 {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            int[] tem = A;
            A = B;
            B = tem;
            int temInt = m;
            m = n;
            n = temInt;
        }

        int i = findI(0, m, A, B);
        int j = (m + n + 1) / 2 - i;
        return getRes(A, B, i, j);
    }

    private double getRes(int[] A, int[] B, int i, int j) {
        int m = A.length;
        int n = B.length;
        double leftMax = 0.0;
        double rightMax = 0.0;
        if (i == 0) {
            leftMax = B[j - 1];
        } else if (j == 0) {
            leftMax = A[i - 1];
        } else {
            leftMax = Math.max(A[i - 1], B[j - 1]);
        }
        if ((m + n) % 2 == 1) return leftMax;
        if (i == m) {
            rightMax = B[j];
        } else if (j == n) {
            rightMax = A[i];
        } else {
            rightMax = Math.min(A[i], B[j]);
        }
        return (leftMax + rightMax) * 1.0 / 2;
    }

    private int findI(int minM, int maxM, int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        int i = (minM + maxM) / 2;
        int j = (m + n + 1) / 2 - i;
        if (i > 0 && j < n && a[i - 1] > b[j]) return findI(minM, i - 1, a, b);
        if (i < m && j > 0 && b[j - 1] > a[i]) return findI(i + 1, maxM, a, b);
        return i;
    }

    public static void main(String[] args) {
        int[] a = {};
        int[] b = {2, 3, 4};
        System.out.println(new Solution4().findMedianSortedArrays(a, b));
    }
}