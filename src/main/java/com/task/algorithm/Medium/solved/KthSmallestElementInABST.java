package com.task.algorithm.Medium.solved;

/**
 * 230. Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 * Given the root of a binary search tree, and an integer k,
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 *
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 * Constraints:
 *
 * The number of nodes in the tree is n.
 *
 * 1 <= k <= n <= 10^4
 * 0 <= Node.val <= 10^4
 *
 * Follow up: If the BST is modified often (i.e., we can do insert and delete operations)
 * and you need to find the kth smallest frequently, how would you optimize?
 */
import java.util.LinkedList;

public class KthSmallestElementInABST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    LinkedList<TreeNode> queue = new LinkedList<>();

    public int kthSmallest(TreeNode root, int k) {
        kthSmallest(root);
        TreeNode poll = queue.pollLast();
        if (poll == null) {
            return 0;
        }
        if (k == 1) {
            return poll.val;
        }
        return kthSmallest(poll.right, k - 1);
    }

    private void kthSmallest(TreeNode root) {
        while (root != null) {
            queue.add(root);
            root = root.left;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node = new TreeNode(1);
        root.left = node;
        node = new TreeNode(4);
        root.right = node;
        node = new TreeNode(2);
        root.left.right = node;

        KthSmallestElementInABST kthSmallest = new KthSmallestElementInABST();
        kthSmallest.kthSmallest(root, 1);
    }
}