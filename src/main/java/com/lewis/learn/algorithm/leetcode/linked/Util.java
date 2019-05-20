package com.lewis.learn.algorithm.leetcode.linked;

/**
 * @author minghzhang
 * @date 2019/05/18
 */
public class Util {

    public static ListNode generatorListNode(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode pointer = dummyHead;
        for (int element : array) {
            ListNode newNode = new ListNode(element);
            pointer.next = newNode;

            pointer = pointer.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = generatorListNode(new int[]{1, 2, 3, 4, 5, 6});
        listNode.print(listNode);
    }
}
