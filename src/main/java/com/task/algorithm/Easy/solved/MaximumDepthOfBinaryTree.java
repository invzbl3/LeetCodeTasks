package com.task.algorithm.Easy.solved;

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */

/*
    Algorithm description:
    ---------------------
    The maximum depth of a binary tree is the number of nodes from the root down to the furthest leaf node.
    In other words, it is the height of a binary tree.

    The algorithm uses recursion to calculate the maximum height:

    1. Recursively calculate the height of the tree to the left of the root.
    2. Recursively calculate the height of the tree to the right of the root.
    3. Pick the larger height from the two answers and add one to it (to account for the root node).
 */

// Java program to find height of tree

// https://www.educative.io/answers/finding-the-maximum-depth-of-a-binary-tree
// A binary tree node

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

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

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

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}

/*
class Node3 {
    int data;
    Node3 left, right;

    Node3(int item) {
        data = item;
        left = right = null;
    }
}

class MaximumDepthOfBinaryTree {
    Node3 root;

    */
/* Compute the "maxDepth" of a tree -- the number of
       nodes along the longest path from the root node
       down to the farthest leaf node.*//*

    int maxDepth(Node3 node) {
        if (node == null)
            return 0;
        else {
            */
/* compute the depth of each subtree *//*

            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            */
/* use the larger one *//*

            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    */
/* Driver program to test above functions *//*

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree tree = new MaximumDepthOfBinaryTree();

        tree.root = new Node3(1);
        tree.root.left = new Node3(2);
        tree.root.right = new Node3(3);
        tree.root.left.left = new Node3(4);
        tree.root.left.right = new Node3(5);

        System.out.println("Height of tree is "
                + tree.maxDepth(tree.root));
    }
}*/