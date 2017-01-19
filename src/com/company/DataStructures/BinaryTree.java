package com.company.DataStructures;

/**
 * Created by Bekzod on 3/14/2016.
 */
public class BinaryTree {
    public void preOrderTraversal(TreeNode node){
        if(node == null) return;
        System.out.print(node.value + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
    public void inOrderTraversal(TreeNode node){
        if(node == null) return;
        inOrderTraversal(node.left);
        System.out.print(node.value + " ");
        inOrderTraversal(node.right);
    }
    public void postOrderTraversal(TreeNode node){
        if(node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.value + " ");
    }

    public TreeNode buildFromSortedArray(int[] arr, int start, int end){
        if(start>end) return null;
        int medianIndex = (start + end) / 2;
        TreeNode root = new TreeNode(arr[medianIndex]);
        root.left = buildFromSortedArray(arr, start, medianIndex - 1);
        root.right = buildFromSortedArray(arr, medianIndex + 1, end);
        return root;
    }

    public boolean checkIfBST(TreeNode root){
        return checkIfBSTRecur(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkIfBSTRecur(TreeNode root, int min, int max){
        if(root == null) return true;

        return (root.value > min && root.value < max
                && checkIfBSTRecur(root.left, min, root.value)
                && checkIfBSTRecur(root.right, root.value, max));
    }
}
