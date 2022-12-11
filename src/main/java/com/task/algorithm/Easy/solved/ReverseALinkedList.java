package com.task.algorithm.Easy.solved;

// Java program for reversing linked list using additional space

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */

/*
    206. Reverse Linked List

    Given the head of a singly linked list, reverse the list,
    and return the reversed list.

    Example 1:

    Input: head = [1,2,3,4,5]
    Output: [5,4,3,2,1]

    Example 2:

    Input: head = [1,2]
    Output: [2,1]

    Example 3:

    Input: head = []
    Output: []

    Constraints:

    * The number of nodes in the list is the range
    [0, 5000].
    * -5000 <= Node.val <= 5000


    Follow up: A linked list can be reversed either
    iteratively or recursively. Could you implement both?
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() { }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution2 {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;

        while (head != null) {
            ListNode next_node = head.next;
            head.next = prev;
            prev = head;
            head = next_node;
        }

        return prev;
    }
}

/*public class ReverseALinkedList {
    public static void main(String[] args) {
        // Declaring linkedlist without any initial size
        LinkedList<String> linkedli = new LinkedList<>();
        // Appending elements at the end of the list
        linkedli.add("Cherry");
        linkedli.add("Chennai");
        linkedli.add("Bullet");
        System.out.print("Elements before reversing: " + linkedli);
        linkedli = reverseLinkedList(linkedli);
        System.out.print("\nElements after reversing: " + linkedli);
    }

    // Takes a linkedlist as a parameter and returns a reversed linkedlist
    public static LinkedList<String> reverseLinkedList(LinkedList<String> list) {
        LinkedList<String> revLinkedList = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {

            // Append the elements in reverse order
            revLinkedList.add(list.get(i));
        }
        // Return the reversed arraylist
        return revLinkedList;
    }
}*/

/*
class MyLinkedList {

    public Node head;

    public static class Node {

        Node next;
        Object data;

        Node(Object data) {
            this.data = data;
            next = null;
        }
    }
}

public class ReverseLinkedList {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.head = new Node(1);
        myLinkedList.head.next = new Node(2);
        myLinkedList.head.next.next = new Node(3);

        printLinkedList(myLinkedList);
        reverseLinkedList(myLinkedList);
        printLinkedList(myLinkedList);

    }

    public static void printLinkedList(MyLinkedList linkedList) {
        Node h = linkedList.head;
        while (linkedList.head != null) {
            System.out.print(linkedList.head.data + " ");
            linkedList.head = linkedList.head.next;
        }
        System.out.println();
        linkedList.head = h;
    }

    public static void reverseLinkedList(MyLinkedList linkedList) {
        Node previous = null;
        Node current = linkedList.head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        linkedList.head = previous;
    }
}*/