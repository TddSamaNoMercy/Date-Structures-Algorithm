package com.xym.datastructure.leetcode;

class Solution125 {
    public boolean isPalindrome(String s) {
        String dup = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (!isLegal(dup.charAt(l))) {
                l++;
            } else if (!isLegal(dup.charAt(r))) {
                r--;
            } else if (dup.charAt(l) != dup.charAt(r))
                return false;
            else {
                l++;
                r--;
            }

        }
        return true;
    }

    private boolean isLegal(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution125().isPalindrome("race a car"));
    }
}
