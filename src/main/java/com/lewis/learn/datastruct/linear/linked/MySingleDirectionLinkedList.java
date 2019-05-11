package com.lewis.learn.datastruct.linear.linked;

/**
 * @author fanhuai.zmh@alibaba-inc.com
 * @date 2019/05/11
 * <p>
 * Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list. A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node. If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
 * <p>
 * Implement these functions in your linked list class:
 * <p>
 * get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
 * addAtHead(val) : Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
 * addAtTail(val) : Append a node of value val to the last element of the linked list.
 * addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list.
 * If index equals to the length of linked list, the node will be appended to the end of linked list.
 * If index is greater than the length, the node will not be inserted.
 * deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
 * Example:
 * <p>
 * MySingleDirectionLinkedList linkedList = new MySingleDirectionLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
 * linkedList.get(1);            // returns 2
 * linkedList.deleteAtIndex(1);  // now the linked list is 1->3
 * linkedList.get(1);            // returns 3
 * Note:
 * <p>
 * All values will be in the range of [1, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in LinkedList library.
 * <p>
 * https://leetcode.com/problems/design-linked-list/
 */
public class MySingleDirectionLinkedList {

    private Node head;

    private Node tail;

    private int size;

    public class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MySingleDirectionLinkedList() {
        size = 0;
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.next = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index > size - 1) {
            return -1;
        }
        int currentIndex = -1;
        Node pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
            currentIndex++;
            if (index == currentIndex) {
                return pointer.val;
            }
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node newNode = new Node(val);

        Node pointerNode = head;
        Node preNode = head;
        while (pointerNode.next != null) {
            preNode = pointerNode;
            pointerNode = pointerNode.next;
        }
        preNode.next = newNode;
        newNode.next = tail;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size ) {
            return;
        }
        Node newNode = new Node(val);
        Node pointerNode = head;
        Node preNode = head;
        int currentIndex = -1;
        while (pointerNode.next != null) {
            preNode = pointerNode;
            pointerNode = pointerNode.next;
            currentIndex++;
            if (currentIndex == index) {
                break;
            }
        }
        newNode.next = preNode.next;
        preNode.next = newNode;
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index > size - 1) {
            return;
        }
        Node pointerNode = head;
        Node preNode = head;
        int currentIndex = -1;
        while (pointerNode.next != null) {
            preNode = pointerNode;
            pointerNode = pointerNode.next;
            currentIndex++;
            if (currentIndex == index) {
                break;
            }
        }
        preNode.next = preNode.next.next;

        size--;
    }

    public static void main(String[] args) {
        //["MySingleDirectionLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
        //[[],[1],[3],[1,2],[1],[1],[1]]

        //["MySingleDirectionLinkedList","addAtHead","addAtIndex","get","get","get"]
        //[[],[1],[1,2],[1],[0],[2]]
        MySingleDirectionLinkedList list = new MySingleDirectionLinkedList();
        list.addAtHead(1);
        list.addAtIndex(1,2);
        System.out.println(list.get(1));
        System.out.println(list.get(0));
        System.out.println(list.get(2));
    }
}
