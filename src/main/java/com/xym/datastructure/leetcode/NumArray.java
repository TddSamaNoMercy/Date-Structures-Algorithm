package com.xym.datastructure.leetcode;

import java.util.Arrays;

//303. 区域和检索 - 数组不可变
//class NumArray {
//    private int[] data;
//
//    public NumArray(int[] nums) {
//        data = new int[nums.length + 1];
//        data[0] = 0;
//        for (int i = 1; i < nums.length + 1; i++) {
//            data[i] = data[i - 1] + nums[i - 1];
//        }
//    }
//
//    public int sumRange(int i, int j) {
//        return data[j + 1] - data[i];
//    }
//}
//
///**
// * Your NumArray object will be instantiated and called as such:
// * NumArray obj = new NumArray(nums);
// * int param_1 = obj.sumRange(i,j);
// */
class NumArray {
//
//    int[] data;
//    int[] treeSeg;
//
//    public NumArray(int[] nums) {
//        if (nums.length != 0) {
//            data = nums;
//            treeSeg = new int[nums.length * 4];
//            treeSeg[0] = 0;
//            buildTree(1, 2, 3, 0, nums.length);
//        }
//    }
//
//    private void buildTree(int index, int leftIdx, int rightIdx, int l, int r) {
//
//        if (l == r - 1) {
//            treeSeg[index] = data[l];
//        } else {
//            int mid = l + (r - l) / 2;
//            buildTree(leftIdx, leftIdx * 2, (leftIdx << 1) + 1, l, mid);
//            buildTree(rightIdx, rightIdx * 2, (rightIdx << 1) + 1, mid, r);
//            treeSeg[index] = treeSeg[leftIdx] + treeSeg[rightIdx];
//        }
//    }
//
//    public void update(int i, int val) {
//        data[i] = val;
//        update(1, i, val, 0, data.length);
//    }
//
//    private void update(int index, int i, int value, int l, int r) {
//        if (l == r - 1) {
//            treeSeg[index] = value;
//        } else {
//            int mid = l + (r - l) / 2;
//            if (i >= mid) {
//                update(index * 2 + 1, i, value, mid, r);
//            } else {
//                update(index * 2, i, value, l, mid);
//            }
//            treeSeg[index] = treeSeg[index * 2] + treeSeg[index * 2 + 1];
//        }
//    }
//
//    public int sumRange(int i, int j) {
//        return sumRange(1, i, j + 1, 0, data.length);
//    }
//
//    private int sumRange(int index, int i, int j, int l, int r) {
//        if (i != l || j != r) {
//            int mid = l + (r - l) / 2;
//            if (i >= mid) {
//                return sumRange(index * 2 + 1, i, j, mid, r);
//            } else if (mid >= j) {
//                return sumRange(index * 2, i, j, l, mid);
//            } else {
//                int leftrRes = sumRange(index * 2, i, mid, l, mid);
//                int rightRes = sumRange(index * 2 + 1, mid, j, mid, r);
//                return leftrRes + rightRes;
//            }
//        } else {
//            return treeSeg[index];
//        }
//    }

    int[] org;
    int[] BITree;

    NumArray(int[] nums) {
        if (nums.length != 0) {
            org = nums;
            BITree = new int[nums.length + 1];
            for (int i = 1; i < nums.length + 1; i++) {
                for (int j = 0; j < lowbit(i); j++) {
                    BITree[i] += org[i - j - 1];
                }
            }
        }
    }

    private int lowbit(int x) {
        return x & -x;
    }

    public int sumRange(int i, int j) {
        return sumIndex(j + 1) - sumIndex(i);
    }

    private int sumIndex(int index) {
        int ret = 0, x = index;
        for (; x > 0; ret += BITree[x], x -= lowbit(x));
        return ret;
    }

    public void update(int i, int val) {
        int modify = val - org[i];
        org[i] = val;
        for (int x = i + 1; x < BITree.length; BITree[x] += modify, x += lowbit(x)) ;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        NumArray array = new NumArray(a);
        System.out.println(array);
        array.update(2, -1);
        System.out.println(array);
        System.out.println(array.sumRange(0, 4));
    }

    @Override
    public String toString() {
        return Arrays.toString(BITree) + "\n" + Arrays.toString(org);

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */