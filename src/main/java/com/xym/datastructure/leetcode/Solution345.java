package com.xym.datastructure.leetcode;

import java.util.*;
//在处理字符串变换时要使用StringBuilder或者转化为字符数组
class Solution345 {
    private final HashSet<Character> set = new HashSet<>(Arrays.asList('a','o','e','i','u','A','O','E','I','U'));
    public String reverseVowels(String s) {
        int i = 0,j = s.length()-1;
        char[] result = new char[s.length()];
        while(i<=j){
            char ci = s.charAt(i);
            char cj =s.charAt(j);
            if(!set.contains(ci)){
                result[i++] = ci;
            }else if(!set.contains(cj)){
                result[j--] = cj;
            }else{
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }
}