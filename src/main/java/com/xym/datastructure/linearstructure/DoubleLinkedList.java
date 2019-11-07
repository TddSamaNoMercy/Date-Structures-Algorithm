package com.xym.datastructure.linearstructure;

/**
 * Double LinkedList
 *
 * @param <E>
 */
public class DoubleLinkedList<E> {
    private class Node<E> {
        E e;
        Node pre;
        Node next;

        Node(E e, Node pre, Node next) {
            this.e = e;
            this.pre = pre;
            this.next = next;
        }

        Node(E e) {
            this(e, null, null);
        }

        Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return e == null ? "null" : e.toString();
        }
    }

    private Node tail;
    private Node dh;//虚拟头结点
    private int size;

    public DoubleLinkedList() {
        dh = new Node();
        tail = dh;
        size = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(E e, int index) {
        if (index >= 0 && index <= size) {
            Node preNode = dh;
            for (int i = 0; i < index; i++) {
                preNode = preNode.next;
            }
            Node n = new Node(e, preNode, preNode.next);
            if (preNode.next != null) preNode.next.pre = n;
            preNode.next = n;

            if (preNode == tail) tail = n;
            size++;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void addFirst(E e) {
        add(e, 0);
    }

    public void addLast(E e) {
        add(e, size);
    }

    E get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("非法位置");
        }
        Node cur = dh.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return (E) cur.e;
    }

    public E remove(int index) {
        E e = get(index);
        Node curNode = dh.next;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        if (curNode.next != null) {
            curNode.next.pre = curNode.pre;
        }
        curNode.pre.next = curNode.next;
        if (curNode == tail) {
            tail = curNode.pre;
        }
        size--;
        return e;
    }

    public void removeE(E e) {
        if (isEmpty()) return;
        Node curNode = dh.next;
        while (curNode.next != null) {
            if (curNode.e.equals(e)) {
                curNode.next.pre = curNode.pre;
                curNode.pre.next = curNode.next;
                size--;
            }
            curNode = curNode.next;
        }
        if (tail != null && tail.e.equals(e)) {
            tail.pre.next = null;
            tail = tail.pre;
            size--;

        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("head [");
        Node cur = dh;
        for (int i = 0; i < size; i++) {
            res.append(cur.next);
            if (i != size - 1) {
                res.append("-->");
            }
            cur = cur.next;
        }
        res.append("] tail");
        return res.toString();
    }
}
