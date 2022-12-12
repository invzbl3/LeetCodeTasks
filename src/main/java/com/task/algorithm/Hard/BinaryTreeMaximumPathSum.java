package com.task.algorithm.Hard;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/

/*
    Algorithm description:
    ---------------------
    A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence
    has an edge connecting them. A node can only appear in the sequence at most once. Note that the path
    does not need to pass through the root.

    The path sum of a path is the sum of the node's values in the path.
    Given the root of a binary tree, return the maximum path sum of any non-empty path.

    Example 1:

    Input: root = [1,2,3]
    Output: 6
    Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

    Example 2:

    Input: root = [-10,9,20,null,null,15,7]
    Output: 42
    Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.

    Constraints:

    The number of nodes in the tree is in the range [1, 3 * 104].
    -1000 <= Node.val <= 1000

// https://www.educative.io/answers/the-algorithm-for-the-maximum-sum-in-a-binary-tree

    The maximum sum in a binary tree is the largest sum that can be found in a path
    which may start and end at any node in the tree.

    Algorithm
    Use recursion to find the maximum sum in the left and right sub-trees.

    Compute the maximum of the following four cases:

    Value of root
    Value of root + left sub-tree
    Value of root + right sub-tree
    Value of root + left + right sub-trees
    If the maximum value (found in step 2) is greater than the global max variable,
    update the global maximum.

    Return the maximum of the first three cases.

    The value returned in the last step of the algorithm is the maximum value of only the first three
    cases (mentioned in step 2).
    If the fourth case has the maximum value, then the root and its sub-trees are the top of our max
    sum path (i.e., the root cannot be connected to its parent caller; otherwise,
    the path would start or end at more than one node).
*/

class Node2 {
    int val;
    Node2 left, right;

    Node2(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class BinaryTreeMaximumPathSum {

    public static int maxPathSum(Node2 root) {
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxValue);
        return maxValue[0];
    }

    public static int maxPathDown(Node2 node, int[] maxValue) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left, maxValue));
        int right = Math.max(0, maxPathDown(node.right, maxValue));
        maxValue[0] = Math.max(maxValue[0], left + right + node.val);
        return Math.max(left, right) + node.val;
    }

    public static void main(String[] args) {

        Node2 root = new Node2(-10);
        root.left = new Node2(9);
        root.right = new Node2(20);
        root.right.left = new Node2(15);
        root.right.right = new Node2(7);

        int answer = maxPathSum(root);
        System.out.println("The Max Path Sum for this tree is " + answer);
    }
}