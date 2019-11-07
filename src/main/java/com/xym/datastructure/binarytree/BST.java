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
            size++;
        } else {
            pre.right = new Node(e);
            size++;
        }
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

    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(Node node) {
        if (node == null) return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        Node cur = node;
        Deque<Node> stack = new ArrayDeque<>();
        while (true) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else if (!stack.isEmpty()) {
                cur = stack.pop();
                System.out.println(cur.e);
                cur = cur.right;
            } else {
                break;
            }
        }
//        stack.push(cur);
//        while (true) {
//            while (cur!=null&&cur.left!=null) {
//                stack.push(cur.left);
//                cur = cur.left;
//            }
//            if (stack.isEmpty()) {
//                break;
//            }
//            cur = stack.pop();
//            System.out.println(cur.e);
//            cur = cur.right;
//            if (cur != null) stack.push(cur);
//        }
    }

    public void postOrder() {
        postOrder1(root);
    }

    private void postOrder(Node node) {
        Deque<Node> stack = new ArrayDeque<>();
        Node cur = node;
        stack.push(cur);
        while (stack.isEmpty()) {
            if (!(stack.peek().left == cur) && !(stack.peek().right == cur)) {
                gotoHLVFL(stack);
            }
            cur = stack.pop();
            System.out.println(cur.e);
        }
    }

    private void gotoHLVFL(Deque<Node> stack) {

        while (true) {
            Node cur = stack.peek();
            if (cur.left != null) {
                if (cur.right != null) stack.push(cur.right);
                stack.push(cur.left);
            } else if (cur.right != null) {
                stack.push(cur.right);
            } else
                break;
        }
    }

    public void postOrder1(Node node) {
        if (node == null) return;
        Deque<Node> stack = new ArrayDeque<>();
        Node cur = node;
        stack.push(cur);
        while (!stack.isEmpty()) {
            if (!(stack.peek().left == cur) && !(stack.peek().right == cur)) {
                while (true) {
                    cur = stack.peek();
                    if (cur.left != null) {
                        if (cur.right != null) stack.push(cur.right);
                        stack.push(cur.left);
                    } else if (cur.right != null) {
                        stack.push(cur.right);
                    } else
                        break;
                }
            }
            cur = stack.pop();
            System.out.println(cur.e);
        }
    }


    public void postOrder2(Node node) {
        if (node == null)
            return;
        Deque<Node> s = new ArrayDeque<>();

        Node curNode; //当前访问的结点
        Node lastVisitNode; //上次访问的结点
        curNode = node;
        lastVisitNode = null;

        //把currentNode移到左子树的最下边
        while (curNode != null) {
            s.push(curNode);
            curNode = curNode.left;
        }
        while (!s.isEmpty()) {
            curNode = s.pop();  //弹出栈顶元素
            //一个根节点被访问的前提是：无右子树或右子树已被访问过
            if (curNode.right != null && curNode.right != lastVisitNode) {
                //根节点再次入栈
                s.push(curNode);
                //进入右子树，且可肯定右子树一定不为空
                curNode = curNode.right;
                while (curNode != null) {
                    //再走到右子树的最左边
                    s.push(curNode);
                    curNode = curNode.left;
                }
            } else {
                //访问
                System.out.println(curNode.e);
                //修改最近被访问的节点
                lastVisitNode = curNode;
            }
        } //while
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
