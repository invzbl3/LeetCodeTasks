package com.task.algorithm.Medium;

// { Driver Code Starts
import java.util.*;

/*
Given a singly linked list: A0?A1?…?An-1?An, reorder it to: A0?An?A1?An-1?A2?An-2?…
        For example: Given 1->2->3->4->5 its reorder is 1->5->2->4->3.

        Note: It is recommended do this in-place without altering the nodes' values.

        Input:
        First line of input contains number of testcases T. For each testcase, there will be two lines of input, first of which contains length of linked list and next line contains elements of the nodes of linked list.

        Output:
        Reorder it as explained above.

        User Task:
        The task is to complete the function reorderList() which should reorder the list as required.

        Constraints:
        1 <= T <= 200
        1 <= N <= 200

        Example:
        Input:

        2
        3
        1 2 3
        4
        1 7 3 4

        Output:
        1 3 2
        1 4 7 3
*/

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class ReorderList {
    Node head;  // head of list

    /* Linked list Node*/


    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }

    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String[] args) {
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            ReorderList llist = new ReorderList();

            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            llist.head = new gfg().reorderlist(llist.head);

            llist.printList();

            t--;
        }
    }
}

// } Driver Code Ends
/* Following is the Linked list node structure */

/*class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/

class gfg {
    Node reorderlist(Node head) {
        Node temp = head;
        List<Integer> dataList = new ArrayList<>();
        do {
            dataList.add(temp.data);
            temp = temp.next;
        } while (temp != null);
        temp = head;
        int i = dataList.size();
        int middle = 0;
        boolean even = i % 2 == 0;
        middle = i / 2;
        do {
            Node innerTemp = temp.next;
            Node node = new Node(dataList.get(i - 1));
            temp.next = node;
            node.next = innerTemp;
            i = i - 1;
            if (i == middle) {
                if (even) {
                    temp = temp.next;
                    temp.next = null;
                    break;
                }
                temp.next = null;
                break;
            }
            temp = temp.next;
            temp = temp.next;
        } while (temp != null);
        return head;
    }
}