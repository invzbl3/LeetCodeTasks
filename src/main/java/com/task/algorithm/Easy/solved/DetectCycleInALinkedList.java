package com.task.algorithm.Easy.solved;

/**
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by
 * continuously following the next pointer. Internally, pos is used to denote the index of the node
 * that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * Example 1:
 *
 * Input: head = [3, 2, 0, -4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail
 * connects to the 1st node (0-indexed).
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail
 * connects to the 0th node.
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 * Constraints:
 *
 * The number of the nodes in the list is in the range [0, 10^4].
 * -10^5 <= Node.val <= 10^5
 * pos is -1 or a valid index in the linked-list.
 *
 * Follow up:
 * Can you solve it using O(1) (i.e. constant) memory?
 *
 *
 * An alternative algorithm description:
 * -------------------------------------
 * Given head, the head of a linked list, determine
 * if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node
 * in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
 * Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list.
 * Otherwise, return false.
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list,
 * where the tail connects to the 1st node (0-indexed).
 */

// https://walkingtechie.blogspot.com/2017/01/detect-cycle-in-directed-graph.html

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Definition for singly-linked list.
class ListNode3 {
    int val;
    ListNode next;

    ListNode3(int x) {
        val = x;
        next = null;
    }
}

class DetectCycleInALinkedList {

    /**
     * A linked list is said to contain a cycle if any node is visited more than
     * once while traversing the list.
     * <p>
     * Create a function with one parameter: a pointer to a Node object named
     * head that points to the head of a linked list. Your function must return
     * a boolean denoting whether or not there is a cycle in the list. If there
     * is a cycle, return true; otherwise, return false.
     * <p>
     * Note: If the list is empty, head will be null.
     */
    public boolean hasCycle(ListNode head) {

        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {

            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

/*
class DetectCycleInALinkedList { */
/**
     * A linked list is said to contain a cycle if any node is visited more than
     * once while traversing the list.
     * <p>
     * Create a function with one parameter: a pointer to a Node object named
     * head that points to the head of a linked list. Your function must return
     * a boolean denoting whether or not there is a cycle in the list. If there
     * is a cycle, return true; otherwise, return false.
     * <p>
     * Note: If the list is empty, head will be null.
     *
     * Input Format
     * Our hidden code checker passes the appropriate argument to your function.
     * You are not responsible for reading any input from stdin.
     *
     * Constraints
     * 0 <= list size <= 100
     *
     * Output Format
     *
     * If the list contains a cycle, your function must return true. If the list does not contain a cycle,
     * it must return false. The binary integer corresponding to the boolean value returned by your
     * function is printed to stdout by our hidden code checker.
     */

/*
    public class Node {

        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this(data);
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public boolean hasCycle(Node head) {
        Set<Node> nodes = new HashSet<>();
        Node curr = head;

        while (curr != null) {

            if (!nodes.contains(curr)) {
                nodes.add(curr);
            } else {
                return true;
            }

            curr = curr.getNext();
        }

        return false;
    }

    public boolean hasCycleOtherSolution(Node head) {
        if (head == null) {
            return false;
        } else {
            Node slow = head;
            Node fast = head.getNext();

            while ((fast != null) && (fast.getNext() != null) && (fast != slow)) {
                slow = slow.getNext();
                fast = fast.getNext().getNext();
            }

            return (fast != null) && (fast == slow);
        }
    }
}*/