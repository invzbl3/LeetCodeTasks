package com.task.algorithm.Hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */
class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeKSortedLists {
    public static Node mergeLists(Node[] list, int k) {
        PriorityQueue<Node> priorityQueue;
        priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a ->(a).data));
        priorityQueue.addAll(Arrays.asList(list).subList(0, k));
        Node head = null;
        Node last = null;
        while (!priorityQueue.isEmpty()) {
            Node min = priorityQueue.poll();
            if (head == null) {
                head = last = min;
            }
            else {
                last.next = min;
                last = min;
            }
            if (min.next != null) {
                priorityQueue.add(min.next);
            }
        }
        return head;
    }

    public static void main(String[] s) {
        int k = 3;
        Node[] list = new Node[k];
        list[0] = new Node(11);
        list[0].next = new Node(15);
        list[0].next.next = new Node(17);
        list[1] = new Node(2);
        list[1].next = new Node(3);
        list[1].next.next = new Node(26);
        list[1].next.next.next = new Node(39);
        list[2] = new Node(4);
        list[2].next = new Node(8);
        list[2].next.next = new Node(10);
        System.out.println("The merged list is-->");
        Node head = mergeLists(list, k);
        while (head != null) {
            System.out.print(head.data + ">> ");
            head = head.next;
        }
        System.out.print("null");
    }
}