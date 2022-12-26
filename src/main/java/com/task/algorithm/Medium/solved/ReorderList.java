package com.task.algorithm.Medium.solved;

/**
 * 143. Reorder List
 * https://leetcode.com/problems/reorder-list/
 *
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 *
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 *
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 *
 * Example 2:
 *
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 5 * 10^4].
 * 1 <= Node.val <= 1000
 *
 */
class ListNode3 {
    int val;
    ListNode next;

    ListNode3() {
    }

    ListNode3(int val) {
        this.val = val;
    }

    ListNode3(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class ReorderList {

    public void reorderList(ListNode head) {
        while (head != null && head.next != null) {
            ListNode last = getLast(head);
            last.next = head.next;
            head.next = last;
            head = last.next;
        }
    }

    private ListNode getLast(ListNode head) {
        ListNode cur = head;

        while (cur != null) {
            if (cur.next.next == null) {
                ListNode last = cur.next;
                cur.next = null;
                return last;
            }

            cur = cur.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode(5);
        ListNode node3 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode root = new ListNode(1);

        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(root);

        print(root);
    }

    private static void print(ListNode root) {
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }
}