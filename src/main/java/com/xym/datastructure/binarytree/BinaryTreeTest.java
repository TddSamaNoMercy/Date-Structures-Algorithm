package com.xym.datastructure.binarytree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] arr = {5, 3, 7, 8, 4, 2, 6};
        for (int i : arr) {
            bst.add(i);
        }
//        bst.inOrder();
//        bst.postOrder();
        bst.levelTraverse();
    }
}
