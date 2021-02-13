package com.xym.datastructure.sort;

public class StringTest {
    public static void main(String[] args) {
//        //1： 首先会在Heap中创建对象，然后在常量池中放入zhagnsan 和 wangwu ，但是并不会放入zhagnsanwangwu
//        String a = new String("zhangsan") + "wangwu";
//        // 2：调用 intern ，因为字符串常量池中没有”zhangsanwangwu”这种拼接后的字符串，所以将堆中String对象的引用地址添加到字符串常量池中。jdk1.7后常量池引入到了Heap中，所以可以直接存储引用
//        String b = a.intern();
//        // 3：因为 a 的地址和 b的地址一致，锁以是true
//        System.out.println(a == b);
//
//        //4：因常量池中已经存在 zhangsanwangwu 了，所以直接返回引用就是 a 类型 a ==b 锁 a==b==c
//        String c = "zhangsanwangwu";
//        System.out.println(a == c); // true
//        System.out.println(b == c); // true
//
//        // 5：首先会在Heap中创建对象，然后会在常量池中存储 zhang 和 san
//        String d = new String("zhang") + "san";
//        // 6： 返回的是 常量池中的 地址，因在a变量时已经将 zhangsan 放入到了常量池中
//        String f = d.intern();
//        System.out.println(d == f); // false


        Node node1 = new Node(11);

        Node node2 = new Node(22);
        node1.next = node2;
        Node node3 = new Node(33);
        node2.next = node3;
//        node3.next = node1;

        System.out.println(isLoop(node1));

    }

    public static boolean isLoop(Node head) {
        Node p = head, q = head;
        while (q!= null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if (q == p) return true;
        }
        return false;
    }

    public static class Node {
        public Node(int value) {
            this.value = value;
        }

        int value;
        Node next;
    }

}
