package com.Data_Structures_byprayush.Data_Structures.Linear.Stacks;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class isPalindrome {

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // Empty list or single element list is a palindrome
        }

        // Find the middle of the list using slow and fast pointers
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Reverse the second half of the linked list starting from slow.next
        ListNode secondHalf = reverseList(slow.next);

        // Compare the first half with the reversed second half
        ListNode p1 = head;
        ListNode p2 = secondHalf;
        boolean isPalindrome = true;

        while (p2 != null) {
            if (p1.val != p2.val) {
                isPalindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Restore the list by reversing the reversed second half back
        slow.next = reverseList(secondHalf);

        return isPalindrome;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        scanner.close();

        if (input.equals("-1")) {
            System.out.println("true");
            return;
        }

        String[] values = input.split(" ");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (String value : values) {
            int num = Integer.parseInt(value);
            if (num == -1) break;
            current.next = new ListNode(num);
            current = current.next;
        }

        boolean result = isPalindrome(dummy.next);
        System.out.println(result ? "true" : "false");
    }
}
