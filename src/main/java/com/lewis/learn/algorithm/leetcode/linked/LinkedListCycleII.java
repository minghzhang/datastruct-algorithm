package com.lewis.learn.algorithm.leetcode.linked;

/**
 * @author minghzhang
 * @date 2019/05/11
 * <p>
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * <p>
 * Note: Do not modify the linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * <p>
 * <p>
 * <p>
 * <p>
 * Follow up:
 * Can you solve it without using extra space?
 * <p>
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * <p>
 * 寻找环的入口点：
 * 当fast按照每次2步，slow每次1步的方式走，发现fast和slow重合，确定了单向链表有环路。
 * 接下来，让fast回到链表的头部，重新走，每次步长1，那么当fast和slow再次相遇的时候，就是环路的入口了。
 * 证明：在fast和slow第一次相遇的时候，假定slow走了n步，环路的入口是在p步，那么
 * slow走的路径： p+c ＝ n； c为fast和slow相交点 距离环路入口的距离
 * fast走的路径： p+c+kL = 2n； L为环路的周长，k是整数
 * 显然，如果从p+c点开始，slow再走n步的话，还可以回到p+c这个点。
 * 同时，fast从头开始走，步长为1，经过n步，也会达到p+c这点。
 * 显然，在这个过程中fast和slow只有前p步骤走的路径不同。所以当p1和p2再次重合的时候，必然是在链表的环路入口点上。
 * <p>
 * 作者：GabrielPanda
 * 链接：https://www.jianshu.com/p/19d73fb32f2b
 * 来源：简书
 * 简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode quickPointer = head;
        ListNode slowPointer = head;
        //快慢指针相遇节点
        ListNode meetingNode = null;
        while (quickPointer != null && quickPointer.next != null) {
            quickPointer = quickPointer.next.next;
            slowPointer = slowPointer.next;
            if (quickPointer == slowPointer) {
                meetingNode = quickPointer;
                break;
            }
        }
        if (meetingNode == null) {
            return null;
        }
        //让fast回到链表的头部，重新走，每次步长1，那么当fast和slow再次相遇的时候，就是环路的入口了。
        quickPointer = head;
        slowPointer = meetingNode;
        while (quickPointer != slowPointer) {
            quickPointer = quickPointer.next;
            slowPointer = slowPointer.next;
        }
        return quickPointer;
    }

    public static void main(String[] args) {
        // [-1,-7,7,-4,19,6,-9,-5,-2,-5]
        // 9
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n1.next = null;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        LinkedListCycleII list = new LinkedListCycleII();
        ListNode listNode = list.detectCycle(n1);
        System.out.println(listNode);
    }
}
