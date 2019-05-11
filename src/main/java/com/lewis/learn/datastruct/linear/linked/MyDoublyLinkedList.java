package com.lewis.learn.datastruct.linear.linked;

/**
 * @author minghzhang
 * @date 2019/05/11
 */
public class MyDoublyLinkedList {

    private Node head;

    private Node tail;

    private int size;

    public class Node {
        private int val;
        private Node previous;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyDoublyLinkedList() {
        head = new Node(Integer.MAX_VALUE);

        tail = new Node(Integer.MIN_VALUE);
        head.previous = null;
        head.next = tail;
        tail.previous = head;
        tail.next = null;
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index > size - 1) {
            return -1;
        }
        int mid = size / 2;

        //从前往后找
        if (index < mid) {
            Node pointer = head;
            int currentIndex = -1;
            while (currentIndex < mid) {
                pointer = pointer.next;
                currentIndex++;
                if (currentIndex == index) {
                    return pointer.val;
                }
            }
        }
        //从后往前找 tail,tail-1,tail-2
        else {
            Node pointer = tail;
            int steps = size - index;
            int stepIndex = 0;
            while (stepIndex < steps) {
                pointer = pointer.previous;
                stepIndex++;
            }
            return pointer.val;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list.
     * <p>
     */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head.next;
        newNode.previous = head;
        head.next.previous = newNode;
        head.next = newNode;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        newNode.next = tail;
        newNode.previous = tail.previous;
        tail.previous.next = newNode;
        tail.previous = newNode;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            addAtHead(val);
            return;
        }
        if (index > size) {
            return;
        }
        Node newNode = new Node(val);
        int mid = size / 2;
        //从head节点往后寻找要插入的index
        if (index < mid) {
            Node pointer = head;
            int currentIndex = -1;
            while (currentIndex < mid) {
                pointer = pointer.next;
                currentIndex++;
                if (currentIndex == index) {
                    newNode.next = pointer;
                    newNode.previous = pointer.previous;
                    pointer.previous.next = newNode;
                    pointer.previous = newNode;

                }
            }
        }
        //从tail节点往前寻找要插入的index
        else {
            Node pointer = tail;
            int steps = size - index;
            int stopIndex = 0;
            while (stopIndex < steps) {
                pointer = pointer.previous;
                stopIndex++;
            }
            newNode.next = pointer;
            newNode.previous = pointer.previous;
            pointer.previous.next = newNode;
            pointer.previous = newNode;
        }
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        int mid = size / 2;
        //从head节点往后寻找要插入的index
        if (index < mid) {
            Node pointer = head;
            int currentIndex = -1;
            while (currentIndex < mid) {
                pointer = pointer.next;
                currentIndex++;
                if (currentIndex == index) {
                    pointer.previous.next = pointer.next;
                    pointer.next.previous = pointer.previous;
                }
            }
        }
        //从tail节点往前寻找要插入的index
        else {
            Node pointer = tail;
            int steps = size - index;
            int stopIndex = 0;
            while (stopIndex < steps) {
                pointer = pointer.previous;
                stopIndex++;
            }
            pointer.previous.next = pointer.next;
            pointer.next.previous = pointer.previous;
        }
        size--;
    }

    public static void main(String[] args) {
        //["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
        //[[],[1],[3],[1,2],[1],[1],[1]]
        //["MyLinkedList","addAtIndex","get","deleteAtIndex"]
        //[[],[-1,0],[0],[-1]]
        MyDoublyLinkedList list = new MyDoublyLinkedList();
        //list.addAtHead(1);
        //list.addAtTail(3);
        list.addAtIndex(-1, 0);
        System.out.println(list.get(0));
        list.deleteAtIndex(-1);
        // System.out.println(list.get(1));

    }
}
