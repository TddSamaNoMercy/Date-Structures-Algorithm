package com.xym.datastructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;
//public class Main {
//
//    public static void main(String[] args) {
//
//        DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
//        for(int i = 0 ; i < 5 ; i ++){
//            linkedList.addFirst(i);
//            System.out.println(linkedList);
//        }
//
//        linkedList.add(2, 666);
//        System.out.println(linkedList);
//    }
//}

public class Main {
    public static void main(String[] args) {
//        String s = "1.0";
//        String[] strs = s.split("\\.");
//        for (String str : strs) {
//            System.out.println(str+"\n");
//        }
        CirDoubLinkedList cdLL = new CirDoubLinkedList();
//        DoubleLinkedList<Integer> d = new DoubleLinkedList<>();

        cdLL.addFirst(1);
        System.out.println(cdLL);
        cdLL.addLast(3);
        System.out.println(cdLL);
        cdLL.addFirst(5);
        System.out.println(cdLL);
        cdLL.addLast(7);
        System.out.println(cdLL);
        cdLL.add(9,2);
        System.out.println(cdLL);
        cdLL.add(9,2);
        System.out.println(cdLL);
        cdLL.add(9,2);
        System.out.println(cdLL);
//        cdLL.remove(3);
//        System.out.println(cdLL);
//        cdLL.remove(0);
//        System.out.println(cdLL);
//        cdLL.remove(4);
//        System.out.println(cdLL);
        cdLL.removeE(3);
        System.out.println(cdLL);
        cdLL.removeE(19);
        System.out.println(cdLL);
        cdLL.removeE(9);
        System.out.println(cdLL);

    }
}
