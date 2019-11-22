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
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution3().lengthOfLongestSubstring("pwwkew");
    }
}

