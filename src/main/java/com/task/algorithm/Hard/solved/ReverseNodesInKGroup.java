package com.task.algorithm.Hard.solved;

/**
 * 25. Reverse Nodes in k-Group
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 *
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is
 * not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 *
 * Example 2:
 *
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 * Constraints:
 *
 * * The number of nodes in the list is n.
 * * 1 <= k <= n <= 5000
 * * 0 <= Node.val <= 1000
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        //base case
        if (head.next == null) return head;
        if (k == 1) return head;

        //define pre and cur
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        //reverse the list
        while (cur != null) {
            boolean space = checkHasSpace(k, cur);
            if (space) {
                pre = reverse(pre, cur, k);
                cur = pre.next;
            } else {
                break;
            }
        }
        //return the head
        return dummy.next;
    }

    private boolean checkHasSpace(int k, ListNode cur) {
        for (int i = 1; i <= k; i++) {
            if (cur == null) return false;
            cur = cur.next;
        }
        return true;
    }

    private ListNode reverse(ListNode pre, ListNode cur, int k) {
        for (int i = 0; i < k - 1; i++) {
            ListNode nex = cur.next;
            cur.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return cur;
    }
}