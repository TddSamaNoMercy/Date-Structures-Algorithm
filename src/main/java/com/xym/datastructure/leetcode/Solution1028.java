package com.xym.datastructure.leetcode;

import java.util.Stack;


class Solution1028 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Item {
        TreeNode node;
        int depth;

        Item(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public TreeNode recoverFromPreorder(String S) {
        TreeNode root = null;

        Stack<Item> stack = new Stack<>();
        for (int i = 0; i < S.length(); ) {
            int j = i;
            int depth = 0;
            boolean isPop = false;
            if (S.charAt(i) == '-') {
                while (j < S.length() && S.charAt(j) == '-') {
                    j++;
                }
                depth = j - i;
                i = j;
                while (!stack.empty() && stack.peek().depth >= depth) {
                    stack.pop();
                    isPop = true;
                }
            }
            while (j < S.length() && S.charAt(j) != '-') {
                j++;
            }
            int val = Integer.parseInt(S.substring(i, j));
            i = j;
            TreeNode node = new TreeNode(val);
            if (root == null)
                root = node;
            Item item = new Item(node, depth);
            if (!stack.empty()) {
                if (isPop) {
                    stack.peek().node.right = node;
                } else {
                    stack.peek().node.left = node;
                }
            }
            stack.push(item);
        }
        return root;
    }

}
