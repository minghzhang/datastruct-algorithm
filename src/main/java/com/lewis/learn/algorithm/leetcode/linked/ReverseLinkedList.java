package com.lewis.learn.algorithm.leetcode.linked;

/**
 * @author minghzhang
 * @date 2019/05/12
 * <p>
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * <p>
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ReverseLinkedList list = new ReverseLinkedList();
        ListNode listNode = list.reverseList(n1);
        listNode.print(listNode);
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode currentPointer = head;
        while (currentPointer != null) {
            ListNode nextTemp = currentPointer.next;
            currentPointer.next = pre;
            pre = currentPointer;
            pre.print(pre);
            currentPointer = nextTemp;
        }
        return pre;
    }
}
