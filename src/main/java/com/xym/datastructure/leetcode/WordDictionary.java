package com.xym.datastructure.leetcode;

import java.util.HashMap;
import java.util.Map;

//211. 添加与搜索单词 - 数据结构设计
class WordDictionary {
    class Node {
        boolean isWord;
        Map<Character, Node> next;

        Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }

        Node() {
            this(false);
        }
    }

    Node root;

    /**
     * Initialize your data structure here.
     */
    WordDictionary() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(root, 0, word);
    }

    private boolean search(Node node, int index, String word) {
        if (index == word.length()) return node.isWord;
        char c = word.charAt(index);
        if (c != '.') {
            if (node.next.get(c) != null) {
                return search(node.next.get(c), index + 1, word);
            }
            return false;
        }
        for (char cha : node.next.keySet()) {
            if (search(node.next.get(cha), index + 1, word)) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */