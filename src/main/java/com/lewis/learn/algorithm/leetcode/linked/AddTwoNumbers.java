package com.lewis.learn.algorithm.leetcode.linked;

/**
 * @author minghzhang
 * @date 2019/05/18
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * <p>
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = Util.generatorListNode(new int[]{9, 9});
        ListNode l2 = Util.generatorListNode(new int[]{1});
        l1.print(l1);
        l2.print(l2);
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode = addTwoNumbers.addTwoNumbers(l1, l2);
        listNode.print(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode pointer = dummyHead;
        boolean jinWeiFlag = false;
        while (l1 != null && l2 != null) {
            int sum = 0;
            if (jinWeiFlag) {
                sum = l1.val + l2.val + 1;
            } else {
                sum = l1.val + l2.val;
            }

            if (sum >= 10) {
                ListNode newNode = new ListNode(sum - 10);
                pointer.next = newNode;
                pointer = pointer.next;
                jinWeiFlag = true;
            } else {
                ListNode newNode = new ListNode(sum);
                pointer.next = newNode;
                pointer = pointer.next;
                jinWeiFlag = false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            ListNode newNode;
            if (jinWeiFlag) {
                if (l1.val + 1 >= 10) {
                    newNode = new ListNode(l1.val + 1 - 10);
                    jinWeiFlag = true;
                } else {
                    newNode = new ListNode(l1.val + 1);
                    jinWeiFlag = false;
                }
            } else {
                newNode = l1;
            }
            pointer.next = newNode;
            pointer = pointer.next;
            l1 = l1.next;
        }

        while (l2 != null) {

            ListNode newNode;
            if (jinWeiFlag) {
                if (l2.val + 1 >= 10) {
                    newNode = new ListNode(l2.val + 1 - 10);
                    jinWeiFlag = true;
                } else {
                    newNode = new ListNode(l2.val + 1);
                    jinWeiFlag = false;
                }
            } else {
                newNode = l2;
            }
            pointer.next = newNode;
            pointer = pointer.next;
            l2 = l2.next;
        }

        if (jinWeiFlag) {
            pointer.next = new ListNode(1);
        }


        return dummyHead.next;
    }

}
