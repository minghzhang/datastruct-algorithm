package com.lewis.learn.algorithm.leetcode.linked;

import java.util.List;

/**
 * @author minghzhang
 * @date 2019/05/08
 * <p>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        //l3.next = l4;
        //l4.next = l5;
        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
        ListNode listNode = removeDuplicatesFromSortedList.deleteDuplicates(l1);
        System.out.println(listNode);

    }

    public ListNode deleteDuplicatesRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicatesRecursion(head.next);
        return head.next != null ? head.next : head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pointerNode = head;
        while (pointerNode != null && pointerNode.next != null) {
            if (pointerNode.val == pointerNode.next.val) {
                pointerNode.next = pointerNode.next.next;
            } else {
                pointerNode = pointerNode.next;
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
