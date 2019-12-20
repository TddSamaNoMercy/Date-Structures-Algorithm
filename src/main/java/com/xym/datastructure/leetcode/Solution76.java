package com.xym.datastructure.leetcode;

public class Solution76 {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0
                || t == null || t.length() == 0 || t.length() > s.length())
            return "";
        int l = 0, r = -1;
        int ansIndex = -1, ansLen = s.length() + 1;
        int[] tArr = new int[128];
        int[] subArr = new int[128];
        for (int i = 0; i < t.length(); i++) {
            tArr[t.charAt(i)]++;
        }
        while (l <= s.length() - t.length() && r < s.length()) {
            if (containsStrT(tArr, subArr)){
                if (r - l + 1 < ansLen) {
                    ansIndex = l;
                    ansLen = r - l + 1;
                }
                subArr[s.charAt(l++)]--;
            } else if (r + 1 < s.length()){
                subArr[s.charAt(++r)]++;
            } else
                r++;
        }
        if (ansIndex == -1) {
            return "";
        }
        return s.substring(ansIndex, ansIndex + ansLen);
    }

    private boolean containsStrT(int[] tArr, int[] subArr) {
        for (int i = 0; i < tArr.length; i++) {
            if (tArr[i] > subArr[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution76().minWindow("ADOBECODEBANC", "ABC"));
    }
}
