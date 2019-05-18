package com.lewis.learn.algorithm.leetcode.linked;

/**
 * @author minghzhang
 * @date 2019/05/14
 * <p>
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example:
 * <p>
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * <p>
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class RemoveAllElementsFromALinkedListThatEqualsValue {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(6);
        //n1.next = n2;
        //n2.next = n3;
        n3.next = n4;
        //n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        RemoveAllElementsFromALinkedListThatEqualsValue list = new RemoveAllElementsFromALinkedListThatEqualsValue();
        ListNode listNode = list.removeElements(n1, 1);
        listNode.print(listNode);
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        //引入虚拟头结点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode preNode = dummyHead;
        ListNode pointer = head;
        while (pointer != null) {
            ListNode nextTemp = pointer.next;
            if (pointer.val == val) {
                preNode.next = pointer.next;
            } else {
                preNode = pointer;
            }
            pointer = nextTemp;
        }
        return dummyHead.next;
    }
}
