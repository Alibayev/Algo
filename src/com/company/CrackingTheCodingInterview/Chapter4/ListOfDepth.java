package com.company.CrackingTheCodingInterview.Chapter4;

import com.company.DataStructures.LinkedListNode;
import com.company.DataStructures.TreeNode;

import java.util.*;

public class ListOfDepth {
    static int maxLevel = 0;
    public static void main(String[] args){
//        int[] array = {1,2,3,4,5,6,7,8,9,10};
//        TreeNode root = TreeNode.buildFromSortedArray(array, 0, array.length - 1);
//        List<LinkedList<TreeNode>> listsByLevel = new ArrayList<>();
//        fillListByLevel(root, listsByLevel);
//        for (LinkedList<TreeNode> list : listsByLevel){
//            for(TreeNode node : list){
//                System.out.print(node.data);
//            }
//            System.out.println();
//        }

        /*
              1
           /    \
           2    3
           /\   /
          4  5 6
            /
           7
         */
        TreeNode root2 = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root2.setLeftChild(left);
        root2. setRightChild(right);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        left.setLeftChild(four);
        left.setRightChild(five);
        five.setLeftChild(seven);
        right.setLeftChild(six);

        printByVerticalLevel(root2);
        //printRightView(root2);
        //printLeftView(root2);
        //printTopViewOfATree(root);

    }

    public static void fillListByLevel(TreeNode root, List<LinkedList<TreeNode>> list){
        if(root == null){
            return;
        }
        LinkedList<TreeNode> current = new LinkedList<>();
        current.add(root);
        while(current.size() > 0){
            list.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();
            for(TreeNode parent : parents) {
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
    }

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

    private static void printRightViewInternal(TreeNode node, int level, MaxLevelWrapper max){
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



