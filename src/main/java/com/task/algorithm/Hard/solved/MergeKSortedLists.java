package com.task.algorithm.Hard.solved;

/*
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4], [2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 *
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 *
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 *
 * Constraints:
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 10^4.
 */
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    public class ListNode {
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

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode empty = null;
        if (lists.length == 0)
            return empty;
        ListNode temp = lists[0];
        for (int i = 1; i < lists.length; i++) {
            temp = mergeklists(temp, lists[i]);
        }
        return temp;
    }

    public ListNode mergeklists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val < l2.val) {
            l1.next = mergeklists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeklists(l1, l2.next);
            return l2;
        }
    }
}

/*public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // make the multiply merge list to a two merge list problem
    public ListNode mergeKSortedLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        while (lists.length > 1) {
            ListNode mergedList = new ListNode(1);

            for (int i = 0; i < lists.length; i = i + 2) {
                ListNode l1 = lists[i];
                ListNode l2 = lists[i + 1];
                mergedList(mergeTwoLists(l1, l2));
            }

            lists = mergedList;
        }
        return lists[0];
    }

    // method for merge two sorted list
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(1);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        } else if (list2 != null) {
            tail.next = list2;
        }
        return dummy.next;
    }
}*/

/*class MergeKSortedLists {

    static class ListNode {
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

    public ListNode mergeKSortedLists(List<ListNode> lists) {
        if (lists.isEmpty())
            return null;
        if (lists.size() == 1)
            return lists.get(0);
        if (lists.size() == 2)
            return mergeTwoLists(lists.get(0), lists.get(1));
        ListNode tmp;
        tmp = mergeTwoLists(lists.get(0), lists.get(1));
        for (int i = 2; i < lists.size(); i++) {
            tmp = mergeTwoLists(tmp, lists.get(i));
        }
        return tmp;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        ListNode head = l1.val < l2.val ? l1 : l2;
        ListNode p1 = l1 == head ? l1 : l2;
        ListNode p2 = l1 == head ? l2 : l1;
        ListNode pre = null;
        while (p2 != null && p1 != null) {
            if (p1.val <= p2.val) {
                pre = p1;
                p1 = p1.next;
            } else {
                pre = p2;
                p2 = p2.next;
            }
        }
        pre.next = p1 == null ? p2 : p1;
        return head;
    }

    public static void main(String[] args) {

        ArrayList<ListNode> lists = new ArrayList<>();
        lists.add(new ListNode(3));
        lists.add(new ListNode(2));
        lists.add(new ListNode(2));
        lists.add(new ListNode(1));
        lists.add(new ListNode(1));
        lists.add(new ListNode(2));
        MergeKSortedLists mergeKLists = new MergeKSortedLists();
        ListNode node = mergeKLists.mergeKSortedLists(lists);
        print(node);
    }

    private static void print(ListNode listNode) {

        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}*/

/*
public class MergeKSortedLists {
    public static Node mergeLists(Node[] list, int k) {
        PriorityQueue<Node> priorityQueue;
        priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> (a).data));
        priorityQueue.addAll(Arrays.asList(list).subList(0, k));
        Node head = null;
        Node last = null;

        while (!priorityQueue.isEmpty()) {

            Node min = priorityQueue.poll();

            if (head == null) {
                head = last = min;
            } else {
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
}*/