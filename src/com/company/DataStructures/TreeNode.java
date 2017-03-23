package com.company.DataStructures;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNode {
    public TreeNode(int data){
        this.data = data;
        size = 1;
    }

    public TreeNode(int data, TreeNode parent){
        this.data = data;
        this.parent = parent;
    }

    public TreeNode left, right, parent;
    public int data;
    public int horizontalDistance;
    private int size = 0;

    public void insertInOrder(int d){
        if( d <= data){
            if(left == null){
                setLeftChild(new TreeNode(d));
            } else {
                left.insertInOrder(d);
            }
        } else {
           if(right == null){
               setRightChild(new TreeNode(d));
           } else {
               right.insertInOrder(d);
           }
        }
        size++;
    }

    public TreeNode find(int d){
        if(d == data){
            return this;
        } else if(d <= data){
            return left != null ? left.find(d) : null;
        } else if (d > data) {
            return right != null ? right.find(d) : null;
        }
        return null;
    }

    public void setLeftChild(TreeNode left){
        this.left = left;
        if(left != null){
            left.parent = this;
        }
    }

    public void setRightChild(TreeNode right){
        this.right = right;
        if(right != null){
            right.parent = this;
        }
    }

    public void preOrderTraversal(TreeNode node){
        if(node == null) return;
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
    public void inOrderTraversal(TreeNode node){
        if(node == null) return;
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }
    public void postOrderTraversal(TreeNode node){
        if(node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }
    public static TreeNode buildFromSortedArray(int[] arr, int start, int end){
        if(start>end) return null;
        int medianIndex = (start + end) / 2;
        TreeNode root = new TreeNode(arr[medianIndex]);
        root.left = buildFromSortedArray(arr, start, medianIndex - 1);
        root.right = buildFromSortedArray(arr, medianIndex + 1, end);
        return root;
    }

    public static boolean checkIfBST(TreeNode root){
        return checkIfBSTRecur(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkIfBSTRecur(TreeNode root, int min, int max){
        if(root == null) return true;

        return (root.data > min && root.data < max
                && checkIfBSTRecur(root.left, min, root.data)
                && checkIfBSTRecur(root.right, root.data, max));
    }

    public static boolean dfs(TreeNode node, int value){
        if(node == null){
            return false;
        }
        System.out.println(node.data);
        if(node.data == value){
            return true;
        }
        return dfs(node.left, value) || dfs(node.right, value);
    }

    public static boolean bfs(TreeNode node, int value){
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);

        while(!queue.isEmpty()){
            TreeNode current = queue.remove();
            System.out.println(current.data);

            if(current.data == value){
                return true;
            }
            if(current.left != null) {
                queue.add(current.left);
            }

            if(current.right != null){
                queue.add(current.right);
            }
        }

        return false;
    }
}
