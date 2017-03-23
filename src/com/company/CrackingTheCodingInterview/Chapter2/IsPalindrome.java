package com.company.CrackingTheCodingInterview.Chapter2;

import com.company.DataStructures.LinkedListNode;

import java.util.Stack;

/**
 * Created by bekzodalibayev on 2/23/17.
 */
public class IsPalindrome {
    public static void main(String[] args){
        LinkedListNode head = new LinkedListNode(2);

        LinkedListNode node1 = new LinkedListNode(1);
        head.setNext(node1);
        LinkedListNode node2 = new LinkedListNode(3);
        node1.setNext(node2);
        LinkedListNode node3 = new LinkedListNode(1);
        node2.setNext(node3);
        LinkedListNode node4 = new LinkedListNode(2);
        //LinkedListNode node5 = new LinkedListNode(2);
        node3.setNext(node4);
        //node4.setNext(node5);
        //System.out.println(isPalindromeByReversing(head));
        System.out.println(isPalindromeByUsingStack(head));
    }

    public static boolean isPalindromeByReversing(LinkedListNode node){
        LinkedListNode reversed = node.reverse(node);
        while(node != null && reversed!= null){
            if(node.data != reversed.data){
                return false;
            }
            node = node.next;
            reversed = reversed.next;
        }
        return true;
    }

    public static boolean isPalindromeByUsingStack(LinkedListNode node){
        Stack<Integer> stack = new Stack<>();
        LinkedListNode slowRunner = node;
        LinkedListNode fastRunner = node;

        while(fastRunner != null && fastRunner.next != null){
            stack.add(slowRunner.data);
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }

        if(fastRunner != null){
            slowRunner = slowRunner.next;
        }

        while(slowRunner != null){
            int data = stack.pop();
            if(data != slowRunner.data) {
                return false;
            }
            slowRunner = slowRunner.next;
        }

        return true;
    }
}
