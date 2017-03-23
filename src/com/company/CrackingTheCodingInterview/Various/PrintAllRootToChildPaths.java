package com.company.CrackingTheCodingInterview.Various;

import com.company.DataStructures.TreeNode;

/**
 * Created by bekzodalibayev on 3/12/17.
 */
public class PrintAllRootToChildPaths {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        PrintAllRootToChildPaths obj = new PrintAllRootToChildPaths();
        obj.printAllPaths(root, new int[10], 0);
    }

    public void printAllPaths(TreeNode root, int[] array, int currentDepth){
        if(root == null){
            return;
        }
        array[currentDepth] = root.data;
        currentDepth++;
        if(root.left == null && root.right == null){
            printSumOfPath(array, currentDepth);
            return;
        }
        printAllPaths(root.left, array, currentDepth);
        printAllPaths(root.right, array, currentDepth);

    }

    private void printPath(int[] array, int currentDepth) {
        for(int i = 0; i < currentDepth; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private void printSumOfPath(int[] array, int currentDepth){
        int sum = 0;
        for(int i = 0; i < currentDepth; i++){
            sum += array[i];
        }
        System.out.println(sum);
    }
}
