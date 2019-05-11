package com.lewis.learn.algorithm.leetcode.linked;

/**
 * @author minghzhang
 * @date 2019/05/11
 * <p>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * For example, the following two linked lists:
 * <p>
 * <p>
 * begin to intersect at node c1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 * <p>
 * <p>
 * Notes:
 * <p>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * <p>
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * <p>
 * <p>
 *
 */
public class IntersectionOfTwoLinkedLists {

    /**
     * 把a、b链表弄成等长，然后一起遍历，最先相等的结点就是交点。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        int lengthA = 0;
        int lengthB = 0;
        while (pointerA != null) {
            pointerA = pointerA.next;
            lengthA++;
        }
        while (pointerB != null) {
            pointerB = pointerB.next;
            lengthB++;
        }
        int step = Math.abs(lengthA - lengthB);
        ListNode longerNode = lengthA >= lengthB ? headA : headB;
        ListNode shorterNode = lengthA >= lengthB ? headB : headA;
        ListNode longerPointer = longerNode;
        int stepIndex = 0;
        while (stepIndex < step) {
            longerPointer = longerPointer.next;
            stepIndex++;
        }

        while (longerPointer != null && shorterNode != null) {
            if (longerPointer == shorterNode) {
                return shorterNode;
            }
            longerPointer = longerPointer.next;
            shorterNode = shorterNode.next;
        }
        return null;
    }


    /**
     * 先将一个链表构成环形链表，然后将该问题转化为 求一个链表里是否有环，求其环形入口的问题
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeGraceFully(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        //先将一个链表HeadA转为环形链表
        ListNode lastNode = headA;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = headA;

        //然后问题就转化为了 求headerB链表是否有环，若有环，求其环形入口节点
        ListNode fastPointer = headB;
        ListNode slowPointer = headB;
        ListNode meetingNode = null;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (fastPointer == slowPointer) {
                meetingNode = fastPointer;
                break;
            }
        }

        //说明没有相交点，即两个链表不想交
        if (meetingNode == null) {
            //防止修改原有的链表结构
            lastNode.next = null;
            return null;
        }

        fastPointer = headB;
        while (fastPointer != slowPointer){
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        //防止修改原有的链表结构
        lastNode.next = null;
        return fastPointer;
    }

    public static void main(String[] args) {
        /**
         * 8
         * [4,1,8,4,5]
         * [5,0,1,8,4,5]
         */
       /* ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(8);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(0);
        ListNode n8 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n6.next = n7;
        n7.next = n8;
        n8.next = n3;*/

        ListNode n1 = new ListNode(1);
        //ListNode n2 = new ListNode(1);


        IntersectionOfTwoLinkedLists intersection = new IntersectionOfTwoLinkedLists();
        ListNode intersectionNode = intersection.getIntersectionNode(n1, n1);
        System.out.println(intersectionNode);
    }

}
