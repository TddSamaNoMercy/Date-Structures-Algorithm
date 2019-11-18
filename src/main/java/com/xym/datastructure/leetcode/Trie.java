package com.xym.datastructure.leetcode;

import java.util.HashMap;
import java.util.Map;

//208. 实现 Trie (前缀树)
class Trie {
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
    Trie() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        return search(root, 0, word);
    }

    private boolean search(Node node, int index, String word) {
        if (index == word.length()) return node.isWord;
        char c = word.charAt(index);

        if (node.next.get(c) != null) {
            return search(node.next.get(c), index + 1, word);
        }
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null) return false;
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) return false;
            cur = cur.next.get(c);
        }
        return true;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */