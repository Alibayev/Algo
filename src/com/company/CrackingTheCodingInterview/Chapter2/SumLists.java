package com.company.CrackingTheCodingInterview.Chapter2;

import com.company.DataStructures.LinkedListNode;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Created by bekzodalibayev on 2/21/17.
 */
public class SumLists {
    public static void main(String[] args){
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node12 = new LinkedListNode(8);
        //LinkedListNode node13 = new LinkedListNode(8);
        node1.setNext(node12);
        //node12.setNext(node13);

        LinkedListNode node2 = new LinkedListNode(0);
       // LinkedListNode node22 = new LinkedListNode(7);
       // LinkedListNode node23 = new LinkedListNode(5);
       // node2.setNext(node22);
       // node22.setNext(node23);
        addTwoNumbers(node1, node2);
        //System.out.println(calculateSum(node1, node2));
    }

    public static int calculateSum(LinkedListNode node1, LinkedListNode node2){
        int carry = 0;
        int sum = 0;
        int exponent = 0;

        while(node1 != null || node2 != null){
            int tempSum = node1.data + node2.data + carry;
            int digit = 0;
            if(tempSum > 9){
                carry = tempSum / 10;
                digit = tempSum % 10;
            } else {
                digit = tempSum;
                carry = 0;
            }

            sum = sum + (digit * (int)Math.pow(10, exponent));
            node1 = node1.next;
            node2 = node2.next;
            exponent++;

        }

        while(node1 != null){
         int tempSum = node1.data + carry;
        }

        if(carry != 0){
            sum += (carry * (int)Math.pow(10, exponent));
        }

        return sum;

    }

    public static LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {
        int sum = 0;
        int carry = 0;
        LinkedListNode current = null;
        LinkedListNode head = null;
        while(l1 != null || l2 != null){
            int temp = carry;
            if(l1 != null) { temp += l1.data; }
            if(l2 != null) { temp += l2.data; }

            sum = temp % 10;
            carry = temp / 10;


            if(l1 != null) { l1 = l1.next; }
            if(l2 != null) { l2 = l2.next; }
            if(head == null){
                current = new LinkedListNode(sum);
                head = current;
            } else {
                current.next = new LinkedListNode(sum);
                current = current.next;
            }

            if(carry != 0){
                current.next = new LinkedListNode(carry);
            }

        }
        return head;
    }
}
