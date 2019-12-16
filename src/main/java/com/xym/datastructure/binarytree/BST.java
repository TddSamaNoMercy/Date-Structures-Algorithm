package com.xym.datastructure.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class BST<E extends Comparable<E>> {
    private class Node {
        E e;
        Node left, right;

        Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = addCirculation(root, e);
    }

    private Node addRecursion(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = addRecursion(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = addRecursion(node.right, e);
        }
        return node;
    }

    private Node addCirculation(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        Node cur = node;
        Node pre = node;

        while (cur != null) {
            pre = cur;
            if (e.compareTo(cur.e) < 0) {
                cur = cur.left;
            } else if (e.compareTo(cur.e) > 0) {
                cur = cur.right;
            } else
                return node;
        }
        if (e.compareTo(pre.e) < 0) {
            pre.left = new Node(e);
        } else {
            pre.right = new Node(e);
        }
        size++;
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) return false;
        if (e.compareTo(node.e) == 0) return true;
        else if (e.compareTo(node.e) < 0) return contains(node.left, e);
        else return contains(node.right, e);
    }


    public void levelTraverse() {
        levelTraverse(root);
    }

    private void levelTraverse(Node node) {
        Deque<Node> queue = new LinkedList<>();
        Node cur = node;
        Node last = node;
        Node nLast = node;
        queue.offer(cur);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
                nLast = queue.getLast();
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                nLast = queue.getLast();
            }
            if (last == cur) {
                System.out.print(cur.e + "\n");
                last = nLast;
            } else {
                System.out.print(cur.e + " ");
            }
        }
    }

    //    private E depth(int depth) {
//        StringBuilder res = new StringBuilder();
//        res.append(" ");
//        return res.toString();
//    }
    private Node getMax(Node node) {
        if (node == null) throw new IllegalArgumentException();
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public E removeMax() {
        E res = getMax(root).e;
        root = removeMax(root);
        return res;
    }

    private Node removeMax(Node node) {
        if (node == null) throw new IllegalArgumentException();
        if (node.right == null) {
            node = node.left;
            size--;
            return node;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void inorder() {
        inorder(root);
    }

    public void postorder(){
        postorder(root);
    }

    private void postorder(Node node) {
        Deque<Node> stack = new ArrayDeque<>();
        Node pre = null;
        Node cur = node;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (cur.right == null || pre == cur.right) {
                    System.out.print(cur.e + " ");
                    pre = cur;
                    cur = null;
                } else {
                    stack.push(cur);
                    cur = cur.right;
                }
            }
        }
    }

    private void inorder(Node node) {
        if (node!=null) {
            inorder(node.left);
            System.out.print(node.e + " ");
            inorder(node.right);
        }
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) return null;
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            }
            if (node.right == null) {
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            } else {
                Node suc = getMax(node.left);
                suc.left = removeMax(node.left);
                suc.right = node.right;
                node = null;
                return suc;
            }
        }
    }

}
