package com.lewis.learn.algorithm.leetcode.linked;

/**
 * @author minghzhang
 * @date 2019/05/14
 * <p>
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2
 * Output: false
 * Example 2:
 * <p>
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * <p>
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        PalindromeLinkedList list = new PalindromeLinkedList();
        System.out.println(list.isPalindrome(n1));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        ListNode preNode = null;
        while (slowPointer != null) {
            ListNode tempNode = slowPointer.next;
            slowPointer.next = preNode;
            preNode = slowPointer;
            slowPointer = tempNode;
        }

        while (head != null && preNode != null) {
            if (head.val != preNode.val) {
                return false;
            }
            head = head.next;
            preNode = preNode.next;
        }

        return true;
    }


}
