package com.task.algorithm.Medium.solved;

/**
 * 24. Swap Nodes in Pairs
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the
 * problem without modifying the values in the list's nodes (i.e., only nodes themselves
 * may be changed.)
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 *
 * Example 2:
 *
 * Input: head = []
 * Output: []
 *
 * Example 3:
 *
 * Input: head = [1]
 * Output: [1]
 *
 * Constraints:
 *
 * * The number of nodes in the list is in the range [0, 100].
 * * 0 <= Node.val <= 100
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        return swapPairs(head, head.next);
    }

    private ListNode swapPairs(ListNode current, ListNode next) {
        if (current == null)
            return null;
        else if (next == null)
            return current;
        else {
            ListNode save = next.next;
            next.next = current;

            if (save != null && save.next != null)
                current.next = swapPairs(save, save.next);
            else if (save != null)
                current.next = swapPairs(save, null);
            else
                current.next = null;

            return next;
        }
    }
}