package com.company.CrackingTheCodingInterview.Chapter4;

import com.company.DataStructures.TreeNode;

/**
 * Created by bekzodalibayev on 2/26/17.
 */
public class KSmallesInTree {
    static int num = 0;
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        TreeNode root = TreeNode.buildFromSortedArray(array, 0, array.length - 1);
        //findKthSmallestNodeInATree(root, 3);
        successor(root);
    }

    public static void findKthSmallestNodeInATree(TreeNode node, int k){
        if(node == null) return;
        if(node.left != null) {
            findKthSmallestNodeInATree(node.left, k);
        }
        num++;
        if(num == k) {
            System.out.println("K smallest element is " + node.data);
            return;
        }
        if(node.right != null) {
            findKthSmallestNodeInATree(node.right, k);
        }

    }

    public static void successor(TreeNode node){
        if(node.right != null){
            node = node.right;
        }
        while(node.left != null){
            node = node.left;
        }

        System.out.println("successor is " + node.data);
    }
}
