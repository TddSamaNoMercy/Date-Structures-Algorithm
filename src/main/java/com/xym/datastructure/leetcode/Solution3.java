package com.xym.datastructure.leetcode;

import java.util.HashMap;
import java.util.Map;

//class Solution3 {
//    public int lengthOfLongestSubstring(String s) {
//        int maxLength = 0;
//        int lastIndex = -1;
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (map.containsKey(c) && map.get(c) > lastIndex) {
//                maxLength = Math.max(i - lastIndex -1, maxLength);
//                lastIndex = map.get(c);
//            }
//            map.put(c, i);
//        }
//        return Math.max(maxLength, s.length() - lastIndex -1);
//
//    }
//}
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;

        Map<Character, Integer> map = new HashMap<>(); // current index of character
        for (int l = 0, r = 0; r < n; r++) {
            if (map.containsKey(s.charAt(r))) {
                l = Math.max(map.get(s.charAt(r)) + 1, l);
            }
            ans = Math.max(ans, r - l);
            map.put(s.charAt(r), r);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("abba"));
    }
}

