package com.lewis.learn.algorithm.leetcode.linked;

/**
 * @author fanhuai.zmh@alibaba-inc.com
 * @date 2019/05/08
 */
public class MergeTwoSortedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(7);
        l4.next = l5;
        l5.next = l6;

        MergeTwoSortedList mergeDemo = new MergeTwoSortedList();
        ListNode listNode = mergeDemo.mergeTwoLists(l1, l4);
        System.out.println(listNode);

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode header = new ListNode(-1);
        ListNode currentPointNode = header;

        ListNode p = new ListNode(l1.val);
        ListNode q = new ListNode(l2.val);
        ListNode newNode;
        for (; l1 != null && l2 != null; ) {
            if (p.val <= q.val) {
                newNode = new ListNode(p.val);
                currentPointNode.next = newNode;
                currentPointNode = newNode;
                if (l1.next != null) {
                    p = new ListNode(l1.next.val);
                }
                l1 = l1.next;
            } else {
                newNode = new ListNode(q.val);
                currentPointNode.next = newNode;
                currentPointNode = newNode;
                if (l2.next != null) {
                    q = new ListNode(l2.next.val);
                }
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            p = l1;
            newNode = new ListNode(p.val);
            currentPointNode.next = newNode;
            currentPointNode = newNode;
            l1 = l1.next;
        }

        while (l2 != null) {
            q = l2;
            newNode = new ListNode(q.val);
            currentPointNode.next = newNode;
            currentPointNode = newNode;
            l2 = l2.next;
        }

        return header.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
