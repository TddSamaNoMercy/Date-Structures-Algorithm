package com.xym.datastructure.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 二分搜索树
// 由于Key需要能够进行比较，所以需要extends Comparable<Key>
public class RedBlackTree<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private final Node nil = new Node();

    // 树中的节点类
    public class Node {
        Key key;
        Value value;
        Node left, right, p;
        boolean color;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            p = left = right = nil;
            color = RED;
        }

        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
            this.p = node.p;
            this.color = node.color;

        }

        public Node() {
        }
    }

    private Node root;  // 根节点
    private int count;  // 树种的节点个数

    // 构造函数, 默认构造一棵空二分搜索树
    public RedBlackTree() {
        root = nil;
        count = 0;
    }

    // 返回二分搜索树的节点个数
    public int size() {
        return count;
    }

    // 返回二分搜索树是否为空
    public boolean isEmpty() {
        return count == 0;
    }


    // 在二分搜索树中搜索键key所对应的值。如果这个值不存在, 则返回null
    public Value search(Key key) {
        return search(root, key);
    }


    // 寻找二分搜索树的最小的键值
    public Key minimum() {
        assert count != 0;
        Node minNode = minimum(root);
        return minNode.key;
    }

    public Node successor(Key key) {
        Node node = getNode(root, key);
        if (node != nil)
            return successor(node);
        else
            return nil;

    }


    // 向二分搜索树中插入一个新的(key, value)数据对
    public void insert(Key key, Value value) {
        if (getNode(root, key) != nil) {
            Node node = getNode(root, key);
            node.value = value;
        } else {
            insert(new Node(key, value));
        }
    }

    // 从二分搜索树中删除键值为key的节点
    public void remove(Key key) {
        Node node = getNode(root, key);
        if (node != nil) {
            remove(node);
        }
    }

    //********************
    //* 二分搜索树的辅助函数
    //********************

    //左旋转
    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != nil) {
            y.left.p = x;
        }
        y.p = x.p;
        if (x.p == nil) {
            root = y;
        } else if (x.p.left == x) {
            x.p.left = y;
        } else {
            x.p.right = y;
        }
        y.left = x;
        x.p = y;
    }

    //右旋转
    private void rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;
        if (x.right != nil) {
            x.right.p = y;
        }
        x.p = y.p;
        if (y.p == nil) {
            root = x;
        } else if (y.p.left == y) {
            y.p.left = x;
        } else {
            y.p.right = x;
        }
        x.right = y;
        y.p = x;
    }

    //是否符合二叉搜索树
    public boolean isBST() {
        List<Key> list = new ArrayList<>();
        list = inorder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0)
                return false;
        }
        return true;
    }

    //返回给定key的后继
    private Node successor(Node node) {
        if (node.right != nil) {
            return minimum(node.right);
        }
        Node y = node.p;
        while (y != nil && y.right == node) {
            node = y;
            y = y.p;
        }
        return y;
    }

    private Node getNode(Node node, Key key) {
        while (node != nil && node.key.compareTo(key) != 0) {
            if (node.key.compareTo(key) > 0) {
                node = node.left;
            } else {
                node = node.right;
            }

        }
        return node;
    }

    // 向当前红黑树中插入接点node
    private void insert(Node node) {
        Node x = root;
        Node y = nil;
        while (x != nil) {
            y = x;
            if (x.key.compareTo(node.key) > 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        node.p = y;
        if (y == nil) {
            root = node;
        } else if (y.key.compareTo(node.key) > 0) {
            y.left = node;
        } else {
            y.right = node;
        }
        count++;
        insertFixUp(node);
    }

    private void insertFixUp(Node z) {
        while (z.p.color == RED) {
            if (z.p == z.p.p.left) {
                Node y = z.p.p.right;
                if (y.color == RED) {
                    z.p.color = BLACK;
                    z.p.p.color = RED;
                    y.color = BLACK;
                    z = z.p.p;
                } else {
                    if (z.p.right == z) {
                        z = z.p;
                        leftRotate(z);
                    }
                    z.p.color = BLACK;
                    z.p.p.color = RED;
                    rightRotate(z.p.p);
                }
            } else {
                Node y = z.p.p.left;
                if (y.color == RED) {
                    z.p.color = BLACK;
                    z.p.p.color = RED;
                    y.color = BLACK;
                    z = z.p.p;
                } else {
                    if (z.p.left == z) {
                        z = z.p;
                        rightRotate(z);
                    }
                    z.p.color = BLACK;
                    z.p.p.color = RED;
                    leftRotate(z.p.p);
                }
            }
        }
        root.color = BLACK;
    }


    // 在以node为根的二分搜索树中查找key所对应的value, 递归算法
    // 若value不存在, 则返回NULL
    private Value search(Node node, Key key) {
        Node res = getNode(node, key);
        return res.value;
    }

    // 对以node为根的二叉搜索树进行中序遍历, 递归算法
    private List<Key> inorder(Node node, List<Key> list) {
        Node cur = node;
        Deque<Node> stack = new ArrayDeque<>();
        while (cur != nil || !stack.isEmpty()) {
            if (cur != nil) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.key);
                cur = cur.right;
            }
        }
        return list;
    }


    // 返回以node为根的二分搜索树的最小键值所在的节点
    private Node minimum(Node node) {
        while (node.left != nil)
            node = node.left;

        return node;
    }


    // 删除掉以root为根的二分搜索树中键值为key的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根
    private void remove(Node z) {
        if (z.right == nil) {
            transplant(z.left, z);

        } else if (z.left == nil) {
            transplant(z.right, z);
        } else {
            Node y = minimum(z.right);
            if (y != z.right) {
                transplant(y.right, y);
                y.right = z.right;
                y.right.p = y;
            }
            transplant(y, z);
            y.left = z.left;
            y.left.p = y;
        }
        count--;
    }

    //将以node1为根的子树移植到以node2为根子树的位置上
    private void transplant(Node node1, Node node2) {
        if (node2.p == nil) {
            root = node1;
        } else if (node2 == node2.p.left) {
            node2.p.left = node1;
        } else {
            node2.p.right = node1;
        }
        node1.p = node2.p;
    }

    //层序打印红黑树

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RBTree: " + count + "\n");
        Queue<Node> queue = new LinkedList<>();
        Node curEnd = root, preEnd = root;
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            sb.append(cur.key + " ");
            if (cur.color == BLACK) {
                sb.append("BLACK   ");
            } else {
                sb.append("RED   ");
            }
            if (cur.left != nil) {
                queue.offer(cur.left);
                curEnd = cur.left;
            }
            if (cur.right != nil) {
                queue.offer(cur.right);
                curEnd = cur.right;
            }
            if (cur == preEnd) {
                sb.append("\n");
                preEnd = curEnd;
            }
        }

        return sb.toString();
    }
    class A {

    }

    // 测试二分搜索树
    public static void main(String[] args) {
//        RedBlackTree rbt = new RedBlackTree<>();
//        rbt.insert(0, 4);
//        rbt.insert(2, 12);
//        rbt.insert(4, 5);
//        rbt.insert(6, 1);
//        rbt.insert(8, 223);
//        rbt.insert(7, 10);
//        rbt.insert(10, 3);
//        rbt.insert(5, 51);
//        rbt.insert(12, 141);
//        System.out.println(rbt.isBST());
//        System.out.println(rbt);
//        rbt.remove(6);
//        System.out.println(rbt);
//
//        rbt.remove(2);
//        System.out.println(rbt);
//
//        System.out.println(rbt.isBST());
    }

}
