package com.task.algorithm.Medium.solved;

/**
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in
 * reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a
 * linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 * Constraints:
 *
 * * The number of nodes in each linked list is in the range [1, 100].
 * * 0 <= Node.val <= 9
 * * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode(0);
        int carry = 0;
        ListNode p = l1, q = l2, currNode = headNode;
        while (null != p || null != q) {
            int pVal = p == null ? 0 : p.val;
            int qVal = q == null ? 0 : q.val;
            int sumVal = pVal + qVal + carry;
            carry = sumVal / 10;
            int curVal = sumVal % 10;
            currNode.next = new ListNode(curVal);
            currNode = currNode.next;

            if (null != p) p = p.next;
            if (null != q) q = q.next;
        }
        if (carry > 0) {
            currNode.next = new ListNode(carry);
        }
        return headNode.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode headNode = new ListNode(0);
        headNode.next = l1;
        ListNode p = l1, q = l2, currNode = headNode;

        while (null != p || null != q) {
            if (null == p) {
                p = new ListNode(0);
            }
            int pVal = p.val;
            int qVal = q == null ? 0 : q.val;
            int sumVal = pVal + qVal + carry;
            carry = sumVal / 10;
            int curVal = sumVal % 10;
            p.val = curVal;

            currNode.next = p;
            currNode = currNode.next;
            if (null != q) q = q.next;
            if (null != p) p = p.next;
        }
        if (carry > 0) {
            currNode.next = new ListNode(carry);
        }
        return headNode.next;
    }

    public void print(ListNode listNode) {
        while (null != listNode) {
            System.out.print(listNode.val + ",");
            listNode = listNode.next;
        }
        System.out.println();
    }

    public static ListNode getListNode(int[] a) {
        ListNode headNode = new ListNode(0);
        ListNode listNode = headNode;
        for (int j : a) {
            listNode.next = new ListNode(j);
            listNode = listNode.next;
        }
        return headNode.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        int[] a1 = new int[]{0, 1};
        int[] a2 = new int[]{0, 1, 2};
        ListNode l1 = getListNode(a1);
        ListNode l2 = getListNode(a2);
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        addTwoNumbers.print(result);

        a1 = new int[]{};
        a2 = new int[]{0, 1};
        l1 = getListNode(a1);
        l2 = getListNode(a2);
        result = addTwoNumbers.addTwoNumbers(l1, l2);
        addTwoNumbers.print(result);

        a1 = new int[]{9, 9};
        a2 = new int[]{1};
        l1 = getListNode(a1);
        l2 = getListNode(a2);
        result = addTwoNumbers.addTwoNumbers(l1, l2);
        addTwoNumbers.print(result);
    }
}