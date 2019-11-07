package com.xym.datastructure;

public class CirDoubLinkedList<T> {
    private class Node<T> {
        Node<T> pre;
        Node<T> next;
        T t;

        Node(Node<T> pre, Node<T> next, T t) {
            this.pre = pre;
            this.next = next;
            this.t = t;
        }

        Node(T t) {
            this.t = t;
        }

        Node() {
        }

        @Override
        public String toString() {
            return t.toString();
        }
    }

    Node<T> dmHead;
    int size;

    CirDoubLinkedList() {
        dmHead = new Node<>();
        dmHead.pre = dmHead;
        dmHead.next = dmHead;
    }

    CirDoubLinkedList(int[] arr) {
        this();
        Node preNode = dmHead;
        for (int i = 0; i < arr.length; i++) {
            Node newNode = new Node(preNode, preNode.next, arr[i]);
            preNode.next.pre = newNode;
            preNode.next = newNode;
            preNode = preNode.next;
            size++;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public Node<T> add(T t, int index) {
        if (index < 0 || index > size) throw new IllegalArgumentException();
        Node<T> preNode = dmHead;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        Node<T> node = new Node<>(preNode, preNode.next, t);
        preNode.next.pre = node;
        preNode.next = node;
        size++;
        return dmHead.next;
    }

    Node<T> addFirst(T t) {
        return add(t, 0);
    }

    public Node<T> addLast(T t) {
        return add(t, size);
    }

    Node<T> remove(int index) {
        if (index < 0 || index > size - 1) throw new IllegalArgumentException();
        Node curNode = dmHead.next;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        curNode.pre.next = curNode.next;
        curNode.next.pre = curNode.pre;
        size--;
        return dmHead.next;
    }

    Node<T> removeE(T t) {
        Node<T> curNode = dmHead.next;
        int length = size;
        for (int i = 0; i < length; i++) {
            if (curNode.t.equals(t)) {
                curNode.next.pre = curNode.pre;
                curNode.pre.next = curNode.next;
                size--;
            }
            curNode = curNode.next;
        }
        return dmHead.next;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("head [");
        Node cur = dmHead;
        for (int i = 0; i < size; i++) {
            res.append(cur.next);
            if (i != size - 1) {
                res.append("-->");
            }
            cur = cur.next;
        }
        res.append(']');
        return res.toString();
    }
}
