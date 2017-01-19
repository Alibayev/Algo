package com.company;

import com.company.DataStructures.BinaryTree;
import com.company.DataStructures.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] arr = {1, 2, 3, 4, 6, 7, 8};
        TreeNode root = tree.buildFromSortedArray(arr, 0, arr.length - 1);
        System.out.println(tree.checkIfBST(root));
        System.out.println("Pre-order traversal");
        tree.preOrderTraversal(root);
        System.out.println("\nIn-order traversal");
        tree.inOrderTraversal(root);
        System.out.println("\nPost-order traversal");
        tree.postOrderTraversal(root);

//        HashMap<String, String> map = new HashMap<>();
//        String[] words = {"dbca","bacd"};
//
//        char[] test = "eas".toCharArray();
//        Arrays.sort(test);
//                System.out.println(test);

//        for(String word : words) {
//            char[] arr = Arrays.sort
//            string
//            if(map.containsKey(arr.toString())) {
//
//            }
//        }

    }
}

