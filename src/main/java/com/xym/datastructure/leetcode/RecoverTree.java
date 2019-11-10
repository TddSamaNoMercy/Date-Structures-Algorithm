package com.xym.datastructure.leetcode;


public class RecoverTree {
    static class TreeNode {
        String val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(String x) {
            val = x;
        }
    }

    public TreeNode recoverFromPreorder(String pre, String in) {
        if (pre.length() == 0) return null;
        return helper(pre, in);
    }

    private TreeNode helper(String pre, String in) {
        TreeNode node = new TreeNode(pre.substring(0, 1));
        if (pre.length() == 0) return null;
        if (pre.length() == 1) return new TreeNode(pre);
        int index = 0;
        while ((index < pre.length()) && (pre.charAt(0) != in.charAt(index))) {
            index++;
        }
        if (index == 0) {
            node.left = null;
        } else {
            node.left = helper(pre.substring(1, index + 1), in.substring(0, index));
        }
        if (index != pre.length() - 1) {
            node.right = helper(pre.substring(index + 1), in.substring(index + 1));
        } else {
            node.right = null;
        }
        return node;
    }

}

