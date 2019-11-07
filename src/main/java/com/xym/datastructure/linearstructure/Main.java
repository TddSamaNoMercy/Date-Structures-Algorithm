package com.xym.datastructure.linearstructure;

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
        int[] arr = {1, 4, 5, 6, 3, 8, 8, 7, 4, 1};
        CirDoubLinkedList<Integer> a = new CirDoubLinkedList<>(arr);
        a.add(1, 3);
        System.out.println(a);
        a.addFirst(10);
        System.out.println(a);
        a.remove(7);
        System.out.println(a);
        a.removeE(4);
        System.out.println(a);

//        List<String> a = new LinkedList<>();
//        a.add("A");
//        a.add("B");
//        a.add("C");
//        List<String> b = new LinkedList<>();
//        b.add("D");
//        b.add("E");
//        b.add("F");
//        b.add("G");
//
//        ListIterator<String> aIter = a.listIterator();
//        Iterator<String> bIter = b.iterator();
//
//        while (bIter.hasNext()){
//            if (aIter.hasNext()) aIter.next();
//            aIter.add(bIter.next());
//        }
//        System.out.println(a);
    }
}
