package com.company.CrackingTheCodingInterview.Various;

import com.company.CrackingTheCodingInterview.Chapter4.MaxLevelWrapper;
import com.company.DataStructures.TreeNode;

import java.util.*;

/**
 * Created by bekzodalibayev on 3/11/17.
 */
public class VariousViewsOfBinaryTree {
    static int maxLevel;
//    class MaxLevelWrapper{
//        int maxLevel = 0;
//    }

    public static void printTopViewOfATree(TreeNode root){
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        root.horizontalDistance = 0;
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.remove();

            int horizontalDistance = node.horizontalDistance;
            if(!set.contains(horizontalDistance)){
                set.add(horizontalDistance);
                System.out.print(node.data + " ");
            }

            if(node.left != null){
                node.left.horizontalDistance = horizontalDistance + 1;
                queue.add(node.left);
            }
            if(node.right != null){
                node.right.horizontalDistance = horizontalDistance - 1;
                queue.add(node.right);
            }
        }


    }

    public static void printRightView(TreeNode root){
        int level = 1;
        MaxLevelWrapper max = new MaxLevelWrapper();
        System.out.println("Right View:");
        printRightViewInternal(root, level, max);

    }


    public static void printByVerticalLevel(TreeNode root){
        TreeMap<Integer, LinkedList<Integer>> map = new TreeMap();
        printByVerticalLevelInternal(root, map, 0);

        while(!map.isEmpty()){
            LinkedList<Integer> list = map.pollFirstEntry().getValue();
            for(Integer integer : list){
                System.out.print(integer + " ");
            }
            System.out.println();
        }


    }

    public static void printByVerticalLevelInternal(TreeNode root, TreeMap<Integer, LinkedList<Integer>> map, int horizontalDistance){
        if(root == null){
            return;
        }

        if(!map.containsKey(horizontalDistance)){
            map.put(horizontalDistance, new LinkedList<>());
        }
        map.get(horizontalDistance).add(root.data);

        printByVerticalLevelInternal(root.left, map, horizontalDistance - 1);
        printByVerticalLevelInternal(root.right, map, horizontalDistance + 1);
    }

    private static void printRightViewInternal(TreeNode node, int level, com.company.CrackingTheCodingInterview.Chapter4.MaxLevelWrapper max){
        if(node == null){
            return;
        }

        if(max.maxLevel < level){
            System.out.println(node.data);
            max.maxLevel = level;
        }

        printRightViewInternal(node.right, level + 1, max);
        printRightViewInternal(node.left, level + 1, max);

    }

    public static void printLeftView(TreeNode root){
        maxLevel = 0;
        int level = 1;
        System.out.println("Left View");
        printLeftViewInternal(root, level);

    }

    private static void printLeftViewInternal(TreeNode node, int level){
        if(node == null){
            return;
        }

        if(maxLevel < level){
            System.out.println(node.data);
            maxLevel = level;
        }

        printLeftViewInternal(node.left, level + 1);
        printLeftViewInternal(node.right, level + 1);

    }

}
