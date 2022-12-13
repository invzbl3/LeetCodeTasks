package com.task.algorithm.Hard.solved;

/*
 * 124. Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the
 * sequence has an edge connecting them. A node can only appear in the sequence at most
 * once. Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 *
 * Example 1:
 *
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2
 * + 1 + 3 = 6.
 *
 * Example 2:
 *
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of
 * 15 + 20 + 7 = 42.
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 3 * 10^4].
 * -1000 <= Node.val <= 1000
 *
 * // https://www.educative.io/answers/the-algorithm-for-the-maximum-sum-in-a-binary-tree
 *
 * The maximum sum in a binary tree is the largest sum that can be found in a path
 * which may start and end at any node in the tree.
 *
 * Algorithm
 * Use recursion to find the maximum sum in the left and right sub-trees.
 *
 * Compute the maximum of the following four cases:
 *
 * Value of root
 * Value of root + left sub-tree
 * Value of root + right sub-tree
 * Value of root + left + right sub-trees
 * If the maximum value (found in step 2) is greater than the global max variable,
 * update the global maximum.
 *
 * Return the maximum of the first three cases.
 *
 * The value returned in the last step of the algorithm is the maximum value of only the first three
 * cases (mentioned in step 2).
 * If the fourth case has the maximum value, then the root and its sub-trees are the top of our max
 * sum path (i.e., the root cannot be connected to its parent caller; otherwise,
 * the path would start or end at more than one node).
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// Definition for a binary tree node.
class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2() {
    }

    TreeNode2(int val) {
        this.val = val;
    }

    TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BinaryTreeMaximumPathSum {

    public static int maxPathSum(TreeNode2 root) {
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxValue);
        return maxValue[0];
    }

    public static int maxPathDown(TreeNode2 root, int[] maxValue) {
        if (root == null) return 0;
        int left = Math.max(0, maxPathDown(root.left, maxValue));
        int right = Math.max(0, maxPathDown(root.right, maxValue));
        maxValue[0] = Math.max(maxValue[0], left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {

        TreeNode2 root = new TreeNode2(-10);
        root.left = new TreeNode2(9);
        root.right = new TreeNode2(20);
        root.right.left = new TreeNode2(15);
        root.right.right = new TreeNode2(7);

        int answer = maxPathSum(root);
        System.out.println("The Max Path Sum for this tree is " + answer);
    }
}