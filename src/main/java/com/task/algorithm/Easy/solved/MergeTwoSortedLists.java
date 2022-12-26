package com.task.algorithm.Easy.solved;

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes
 * of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 * Example 1:
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 *
 * Input: list1 = [], list2 = []
 * Output: []
 *
 * Example 3:
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 *
 * An alternative algorithm description:
 * -------------------------------------
 * Given two sorted linked lists consisting of N and M nodes
 * respectively. The task is to merge both of the list
 * (in-place) and return head of the merged list.
 */
class ListNode2 {
    int val;
    ListNode next;

    ListNode2() {
    }

    ListNode2(int val) {
        this.val = val;
    }

    ListNode2(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        final var listNode = new ListNode();

        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val > l2.val) {
            listNode.val = l2.val;
            return mergeTwoLists(l1, l2.next, listNode, listNode);
        } else {
            listNode.val = l1.val;
            return mergeTwoLists(l1.next, l2, listNode, listNode);
        }
    }

    private ListNode mergeTwoLists(final ListNode l1, final ListNode l2, final ListNode next, final ListNode root) {
        if (l1 == null && l2 == null) {
            return root;
        } else if (l1 == null) {
            final var listNode = new ListNode();
            listNode.val = l2.val;
            next.next = listNode;
            return mergeTwoLists(l1, l2.next, listNode, root);
        } else if (l2 == null) {
            final var listNode = new ListNode();
            listNode.val = l1.val;
            next.next = listNode;
            return mergeTwoLists(l1.next, l2, listNode, root);
        } else {
            final var listNode = new ListNode();
            if (l1.val > l2.val) {
                listNode.val = l2.val;
                next.next = listNode;
                return mergeTwoLists(l1, l2.next, listNode, root);
            } else {
                listNode.val = l1.val;
                next.next = listNode;
                return mergeTwoLists(l1.next, l2, listNode, root);
            }
        }
    }
}

/*
class MergeTwoSortedLists {

    */
/* Link list Node *//*

    static class Node {
        int key;
        Node next;
    }

    // Function to reverse a given Linked List using
    // Recursion
    static Node reverseList(Node head) {

        if (head.next == null)
            return head;

        Node rest = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return rest;
    }

    // Given two non-empty linked lists 'a' and 'b'
    static Node sortedMerge(Node a, Node b) {

        // Reverse Linked List 'a'
        a = reverseList(a);

        // Reverse Linked List 'b'
        b = reverseList(b);

        // Initialize head of resultant list
        Node head = null;

        Node temp;

        // Traverse both lists while both of them
        // have nodes.
        while (a != null && b != null) {

            // If a's current value is greater than or equal
            // to b's current value.
            if (a.key >= b.key) {

                // Store next of current Node in first list
                temp = a.next;

                // Add 'a' at the front of resultant list
                a.next = head;

                // Make 'a' - head of the result list
                head = a;

                // Move ahead in first list
                a = temp;
            }

            // If b's value is greater. Below steps are
            // similar to above (Only 'a' is replaced with
            // 'b')
            else {
                temp = b.next;
                b.next = head;
                head = b;
                b = temp;
            }
        }

        // If second list reached end, but first list has
        // nodes. Add remaining nodes of first list at the
        // beginning of result list
        while (a != null) {

            temp = a.next;
            a.next = head;
            head = a;
            a = temp;
        }

        // If first list reached end, but second list has
        // nodes. Add remaining nodes of second list at the
        // beginning of result list
        while (b != null) {

            temp = b.next;
            b.next = head;
            head = b;
            b = temp;
        }

        // Return the head of the result list
        return head;
    }

    */
/* Function to print Nodes in a given linked list *//*

    static void printList(Node Node) {
        while (Node != null) {
            System.out.print(Node.key + " ");
            Node = Node.next;
        }
    }

    */
/* Utility function to create a new node with
       given key *//*

    static Node newNode(int key) {
        Node temp = new Node();
        temp.key = key;
        temp.next = null;
        return temp;
    }

    */
/* Driver program to test above functions*//*

    public static void main(String[] args) {
        */
/* Start with the empty list *//*

        Node res;

        */
/* Let us create two sorted linked lists to test
           the above functions. Created lists shall be
             a: 5.10.15.40
             b: 2.3.20  *//*

        Node a = newNode(5);
        a.next = newNode(10);
        a.next.next = newNode(15);
        a.next.next.next = newNode(40);

        Node b = newNode(2);
        b.next = newNode(3);
        b.next.next = newNode(20);

        */
/* merge 2 sorted Linked Lists *//*

        res = sortedMerge(a, b);

        System.out.println("Merged Linked List is:");
        printList(res);
    }
}*/
