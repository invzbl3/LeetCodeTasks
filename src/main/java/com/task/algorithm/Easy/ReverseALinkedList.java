package com.task.algorithm.Easy;

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */
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
