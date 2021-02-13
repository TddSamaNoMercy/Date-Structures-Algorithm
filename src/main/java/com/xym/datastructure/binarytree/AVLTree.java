//package com.xym.datastructure.binarytree;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.ArrayDeque;
//import java.util.ArrayList;
//import java.util.Deque;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class AVLTree<K extends Comparable<K>, V> {
//
//    private class Node {
//        K key;
//        V value;
//        int height;
//
//        public Node left, right;
//        BufferedReader
//
//
//        Node(K key, V value) {
//            this.key = key;
//            this.value = value;
//            height = 1;
//            left = null;
//            right = null;
//        }
//    }
//
//    private Node root;
//    private int size;
//
//    public AVLTree() {
//        root = null;
//        size = 0;
//    }
//
//    public boolean isBST() {
//        List<K> list = new ArrayList<>();
//        list = inorder(root, list);
//        for (int i = 0; i < list.size() - 1; i++) {
//            if (list.get(i).compareTo(list.get(i + 1)) > 0)
//                return false;
//        }
//        return true;
//    }
//
//    private List<K> inorder(Node node, List<K> list) {
//        Deque<Node> stack = new ArrayDeque<>();
//        Node cur = node;
//        while (cur != null || !stack.isEmpty()) {
//            if (cur != null) {
//                stack.push(cur);
//                cur = cur.left;
//            } else {
//                cur = stack.pop();
//                list.add(cur.key);
//                cur = cur.right;
//            }
//        }
//        return list;
//    }
//
//    public boolean isBalanced() {
//        return isBalanced(root);
//    }
//
//    private boolean isBalanced(Node node) {
//        if (node == null) return true;
//        if (Math.abs(getBalanceFactor(node)) > 1) return false;
//        return isBalanced(node.left) && isBalanced(node.right);
//    }
//
//    public int getHeight(Node node) {
//        if (node == null) return 0;
////        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
//        return node.height;
//    }
//
//    public int getBalanceFactor(Node node) {
//        if (node == null) return 0;
//        return getHeight(node.left) - getHeight(node.right);
//    }
//
//    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
//    //        y                              x
//    //       / \                           /   \
//    //      x   T4     向右旋转 (y)        z     y
//    //     / \       - - - - - - - ->    / \   / \
//    //    z   T3                       T1  T2 T3 T4
//    //   / \
//    // T1   T2
//    private Node rightRotate(Node y) {
//        Node x = y.left;
////        Node T3 = x.right;
//
//        y.left = x.right;
//        x.right = y;
////        y.left = T3;
//
//        // 更新height
//        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
//        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
//
//        return x;
//    }
//
//    public int getSize() {
//        return size;
//    }
//
//    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
//    //    y                             x
//    //  /  \                          /   \
//    // T1   x      向左旋转 (y)       y     z
//    //     / \   - - - - - - - ->   / \   / \
//    //   T2  z                     T1 T2 T3 T4
//    //      / \
//    //     T3 T4
//    private Node leftRotate(Node y) {
//        Node x = y.right;
////        Node T2 = x.left;
//
//        // 向左旋转过程
//        y.right = x.left;
//        x.left = y;
////        y.right = T2;
//
//        // 更新height
//        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
//        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
//
//        return x;
//    }
//
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    // 向二分搜索树中添加新的元素(key, value)
//    public void add(K key, V value) {
//        root = add(root, key, value);
//    }
//
//    // 向以node为根的二分搜索树中插入元素(key, value)，递归算法
//    // 返回插入新节点后二分搜索树的根
//    private Node add(Node node, K key, V value) {
//
//        if (node == null) {
//            size++;
//            return new Node(key, value);
//        }
//
//        if (key.compareTo(node.key) < 0)
//            node.left = add(node.left, key, value);
//        else if (key.compareTo(node.key) > 0)
//            node.right = add(node.right, key, value);
//        else // key.compareTo(node.key) == 0
//            node.value = value;
//
//        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
//
//
//        int balanceFactor = getBalanceFactor(node);
//        if (balanceFactor > 1 && getBalanceFactor(node.left) > 0) {
//
//            return rightRotate(node);
//        }
//        if (balanceFactor < -1 && getBalanceFactor(node.right) < 0) {
//            return leftRotate(node);
//        }
//        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
//            node.left = leftRotate(node.left);
//            return rightRotate(node);
//        }
//        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
//            node.right = rightRotate(node.right);
//            return leftRotate(node);
//        }
//
//        return node;
//    }
//
//    // 返回以node为根节点的二分搜索树中，key所在的节点
//    private Node getNode(Node node, K key) {
//
//        if (node == null)
//            return null;
//
//        if (key.equals(node.key))
//            return node;
//        else if (key.compareTo(node.key) < 0)
//            return getNode(node.left, key);
//        else // if(key.compareTo(node.key) > 0)
//            return getNode(node.right, key);
//    }
//
//    public boolean contains(K key) {
//
//        return getNode(root, key) != null;
//    }
//
//    public V get(K key) {
//
//        Node node = getNode(root, key);
//        return node == null ? null : node.value;
//    }
//
//    public void set(K key, V newValue) {
//        Node node = getNode(root, key);
//        if (node == null)
//            throw new IllegalArgumentException(key + " doesn't exist!");
//
//        node.value = newValue;
//    }
//
//    // 返回以node为根的二分搜索树的最小值所在的节点
//    private Node minimum(Node node) {
//        if (node.left == null)
//            return node;
//        return minimum(node.left);
//    }
//
//
//    // 从二分搜索树中删除键为key的节点
//    public V remove(K key) {
//
//        Node node = getNode(root, key);
//        if (node != null) {
//            root = remove(root, key);
//            return node.value;
//        }
//        return null;
//    }
//
//    private Node remove(Node node, K key) {
//
//        if (node == null)
//            return null;
//
//        Node retNode = node;
//        if (key.compareTo(node.key) < 0) {
//            node.left = remove(node.left, key);
//            retNode = node;
//        } else if (key.compareTo(node.key) > 0) {
//            node.right = remove(node.right, key);
//            retNode = node;
//        } else {   // key.compareTo(node.key) == 0
//
//            // 待删除节点左子树为空的情况
//            if (node.left == null) {
//                Node rightNode = node.right;
//                node.right = null;
//                size--;
//                retNode = rightNode;
//            }
//
//            // 待删除节点右子树为空的情况
//            else if (node.right == null) {
//                Node leftNode = node.left;
//                node.left = null;
//                size--;
//                retNode = leftNode;
//            }
//
//            // 待删除节点左右子树均不为空的情况
//
//            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
//
//            else {// 用这个节点顶替待删除节点的位置
//                Node successor = minimum(node.right);
//                successor.right = remove(node.right, successor.key);
//                successor.left = node.left;
//
//                node.left = node.right = null;
//
//                retNode = successor;
//            }
//        }
//        if (retNode == null) return null;
//        retNode.height = Math.max(getHeight(retNode.left), getHeight(retNode.right)) + 1;
//
//        int balanceFactor = getBalanceFactor(retNode);
//        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0) {
//
//            return rightRotate(retNode);
//        }
//        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0) {
//            return leftRotate(retNode);
//        }
//        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
//            retNode.left = leftRotate(retNode.left);
//            return rightRotate(retNode);
//        }
//        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
//            retNode.right = rightRotate(retNode.right);
//            return leftRotate(retNode);
//        }
//        return retNode;
//    }
//
//
//    public static void main(String[] args) throws IOException {
//
//        System.out.println("Pride and Prejudice");
//
//        List<String> words = new ArrayList<>();
//        File file = new File("src/main/resources/" + "pride-and-prejudice.txt");
//        List<String> list = Files.readAllLines(file.toPath());
//        words = list.stream().flatMap((s) -> Stream.of(s.split(" "))).collect(Collectors.toList());
////        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
//        System.out.println("Total words: " + words.size());
//
//        AVLTree<String, Integer> map = new AVLTree<>();
//        for (String word : words) {
//            if (map.contains(word))
//                map.set(word, map.get(word) + 1);
//            else
//                map.add(word, 1);
//        }
//
//        System.out.println("Total different words: " + map.getSize());
//        System.out.println("Frequency of PRIDE: " + map.get("pride"));
//        System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
//        System.out.println(map.isBST());
//        System.out.println(map.isBalanced());
//
//
////            for(String word: words){
////                map.remove(word);
////            }
////        }
//
//        System.out.println();
//    }
//}
