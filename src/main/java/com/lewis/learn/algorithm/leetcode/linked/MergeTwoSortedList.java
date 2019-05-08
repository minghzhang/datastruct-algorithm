package com.lewis.learn.algorithm.leetcode.linked;

/**
 * @author minghzhang
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
        // ListNode listNode = mergeDemo.mergeTwoLists(l1, l4);
        ListNode listNode = mergeDemo.fastMergeTwoLists(l1, l4);
        System.out.println(listNode);

    }
    /**
     * 递归写法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode recuriveMergeLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {
            l1.next = recuriveMergeLists(l1.next, l2);
            return l1;
        } else {
            l2.next = recuriveMergeLists(l1, l2.next);
            return l2;
        }
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

    public ListNode mostFastMergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode header = new ListNode(-1);
        ListNode currentPointerNode = header;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                currentPointerNode.next = l1;
                currentPointerNode = l1;
                l1 = l1.next;
            } else {
                currentPointerNode.next = l2;
                currentPointerNode = l2;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            currentPointerNode.next = l1;
            currentPointerNode = l1;
            l1 = l1.next;
        }

        while (l2 != null) {
            currentPointerNode.next = l2;
            currentPointerNode = l2;
            l2 = l2.next;
        }

        return header.next;
    }

    public ListNode fastMergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode header = new ListNode(-1);
        ListNode currentPointNode = header;

        ListNode p = l1;
        ListNode q = l2;
        while (l1 != null && l2 != null) {
            if (p.val <= q.val) {
                currentPointNode.next = p;
                currentPointNode = p;
                if (l1.next != null) {
                    p = l1.next;
                }
                l1 = l1.next;
            } else {
                currentPointNode.next = q;
                currentPointNode = q;
                if (l2.next != null) {
                    q = l2.next;
                }
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            currentPointNode.next = l1;
            currentPointNode = l1;
            l1 = l1.next;
        }

        while (l2 != null) {
            currentPointNode.next = l2;
            currentPointNode = l2;
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
