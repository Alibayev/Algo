package com.company.CrackingTheCodingInterview.Chapter2;

import com.company.DataStructures.LinkedListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bekzodalibayev on 2/11/17.
 */
public class RemoveDups {
    public static void main(String[] args){
        LinkedListNode head = new LinkedListNode(2);

        LinkedListNode node1 = new LinkedListNode(1);
        head.setNext(node1);
        LinkedListNode node2 = new LinkedListNode(3);
        node1.setNext(node2);
        LinkedListNode node3 = new LinkedListNode(3);
        node2.setNext(node3);
        LinkedListNode node4 = new LinkedListNode(1);
        LinkedListNode node5 = new LinkedListNode(2);
        node3.setNext(node4);
        node4.setNext(node5);
        printLinkedList(head);
        LinkedListNode reversed = head.reverse(head);
        System.out.println("Reversed");
        printLinkedList(reversed);

    }

    public static void removeDups(LinkedListNode node){
        Set<Integer> hashSet = new HashSet<>();
        LinkedListNode prev = null;

        while(node != null){
            if(!hashSet.contains(node.data)) {
                hashSet.add(node.data);
                prev = node;
            } else{
                prev.next = node.next;
            }
            node = node.next;
        }
    }

    public static void removeDups2(LinkedListNode node){
        LinkedListNode current = node;
        while(current != null){
            LinkedListNode runner = current;
            while(runner.next != null){
                if(runner.next.data == current.data){
                    runner.next = runner.next.next;
                } else{
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void findMiddleNode(LinkedListNode node){
        if(node.next == null){
            System.out.println("There is only one element");
        }
        LinkedListNode current = node;
        LinkedListNode runner = node;

        while(runner.next.next != null){
            current = current.next;
            runner = runner.next.next;
        }
        //current.prev
        System.out.println(current.data);
    }

    public static void printLinkedListFromEnd(LinkedListNode node){
        if(node == null){
            return;
        }
        printLinkedListFromEnd(node.next);
        System.out.println(node.data);
    }

    public static void printLinkedList(LinkedListNode node){
        if(node == null) return;

        System.out.println(node.data);
        printLinkedList(node.next);
    }
}
