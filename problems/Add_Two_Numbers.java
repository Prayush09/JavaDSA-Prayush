package com.Data_Structures_byprayush.problems;

import java.util.LinkedList;

/*
To-do For this problem
1. Know how to reverse a linked list
2. know how to extract value from a linked list
3. Know how to put values in a linked list.
 */
public class Add_Two_Numbers {
    static ListNode head;
    public static class ListNode{
       int val;
       ListNode next;
       ListNode(){}
       ListNode(int val){
           this.val = val;
       }
       ListNode(int val, ListNode next)
       {
           this.val = val;
           this.next = next;
       }
   }

   ListNode reverse(ListNode node)
   {
       ListNode prev = null;
       ListNode current = head;
       ListNode next;
       while(current != null)
       {
           next = current.next;
           current.next = prev;
           prev = current;
           current = next;
       }
       node = prev;
       return node;
   }
    //***KNOWLEDGE GAP***//
   //How to put value together in linked list.

}
