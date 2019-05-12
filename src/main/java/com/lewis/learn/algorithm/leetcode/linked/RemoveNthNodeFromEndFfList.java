package com.lewis.learn.algorithm.leetcode.linked;


/**
 * @author minghzhang
 * @date 2019/05/11
 * <p>
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * <p>
 * Given n will always be valid.
 * <p>
 * Follow up:
 * <p>
 * Could you do this in one pass?
 * <p>
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndFfList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        // n1.next = n2;
        //n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        RemoveNthNodeFromEndFfList list = new RemoveNthNodeFromEndFfList();
        ListNode listNode = list.removeNthFromEndOnce(n1, 1);
        System.out.println(listNode);

    }

    /**
     * 两次遍历
     * 先遍历一次链表，取得链表长度；再计算导倒数第n个元素的位置，
     * 然后从头开始遍历，到这个待删除元素，将其删除
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getListLength(head);
        int forwardStep = length - n;
        //删除头结点即可
        if (forwardStep == 0) {
            return head.next;
        }
        int stepIndex = 0;
        ListNode currentPointer = head;
        ListNode preNode = head;
        while (stepIndex < forwardStep) {
            preNode = currentPointer;
            currentPointer = currentPointer.next;
            stepIndex++;
        }
        preNode.next = currentPointer.next;
        return head;
    }

    private int getListLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode pointer = head;
        int index = 1;
        while (pointer.next != null) {
            pointer = pointer.next;
            index++;
        }
        return index;
    }


    /**
     * 一次遍历
     * 两个指针：fast pointer和slow pointer,
     * 先让fast pointer 走n步，让后fast pointer和slow pointer一起走，
     * 当fast pointer 走到链表链表尾部的时候，slow pointer的位置是倒数第n+1个元素：即要删除元素的前一个元素
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndOnce(ListNode head, int n) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        int advanceIndex = 0;
        while (advanceIndex < n) {
            fastPointer = fastPointer.next;
            advanceIndex++;
        }
        if (fastPointer == null) {
            return head.next;
        }
        while (fastPointer.next != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }

        slowPointer.next = slowPointer.next.next;
        return head;
    }
}
