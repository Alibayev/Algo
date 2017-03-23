package com.company.CrackingTheCodingInterview.Chapter4;

import com.company.DataStructures.TreeNode;

/**
 * Created by bekzodalibayev on 3/3/17.
 */
public class CommonAncestor {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2, root);
        root.left = left;
        TreeNode right = new TreeNode(3, left);
        left.right = right;

        printCommonAncestor(right, root);

    }

    static int getDepth(TreeNode node){
        if(node == null){
            return 0;
        }

        int depth = getDepth(node.parent) + 1;
        return depth;
    }

    static void printCommonAncestor(TreeNode node1, TreeNode node2){
        if(node1 == null || node2 == null){
            System.out.println("There are no common ancestors");
        }

        int depth1 = getDepth(node1);
        int depth2 = getDepth(node2);

        int delta = Math.abs(depth1 - depth2);

        if(depth1 > depth2){
            while(delta != 0){
                node1 = node1.parent;
                delta --;
            }
        } else{
            while(delta != 0){
                node2 = node2.parent;
                delta --;
            }
        }

        while(node1 != null && node2 != null){
            if(node1 == node2){
                System.out.println("Found at " + node2.data);
                return;
            }
            node1 = node1.parent;
            node2 = node2.parent;
        }

        System.out.println("No common ancestors;");
    }
}
