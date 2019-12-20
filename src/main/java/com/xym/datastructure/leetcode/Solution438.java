package com.xym.datastructure.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() < p.length())
            return res;
        int[] origin = new int[26];
        int[] slide = new int[26];
        for (int i = 0; i < p.length(); i++) {
            origin[p.charAt(i) - 'a']++;
            slide[s.charAt(i) - 'a']++;
        }

        int pl = p.length();
        for (int i = 0; i <= s.length() - pl; i++) {
            if (Arrays.equals(origin,slide)) {
                res.add(i);
            }
            slide[s.charAt(i) - 'a']--;
            if (i + pl < s.length())
                slide[s.charAt(i + pl) - 'a']++;

        }
//        for (int i = 0; i < p.length(); i++) {
//            origin[p.charAt(i) - 'a']++;
//        }
//        int l = 0, r = 0;
//        while (r < s.length()) {
//            if (origin[s.charAt(r) - 'a'] == 0) {
//                ++r;
//                while (l < r) {
//                    slide[s.charAt(l++) - 'a'] = 0;
//                }
//            } else {
//                slide[s.charAt(r++) - 'a']++;
//            }
//
//            if (Arrays.equals(origin,slide)){
//                res.add(l);
//            }
//            if (r - l >= p.length()) {
//                slide[s.charAt(l++) - 'a']--;
//            }
//        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution438().findAnagrams("aa","bb"));

    }
}
//foreach 不能修改数组
