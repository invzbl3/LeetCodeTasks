package com.task.algorithm.Medium.solved;

/**
 * 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 *
 * Input: root = [2,1,3]
 * Output: true
 *
 * Example 2:
 *
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 10^4].
 * -2^31 <= Node.val <= 2^31 - 1
 */
class TreeNode3 {
    int val;
    TreeNode3 left;
    TreeNode3 right;

    TreeNode3(int x) {
        val = x;
    }
}

class Solution {
    public static void main(String[] args) {
        TreeNode3 root = new TreeNode3(5);
        TreeNode3 one = new TreeNode3(4);
        TreeNode3 two = new TreeNode3(1);
        TreeNode3 three = new TreeNode3(7);
        TreeNode3 four = new TreeNode3(8);
        root.left = one;
        one.left = two;
        one.right = three;
        root.right = four;
        isValidBST(root);
    }
    public static boolean isValidBST(TreeNode3 root) {
        return isValidBST(root, null, null);
    }

    public static boolean isValidBST(TreeNode3 root, Integer min, Integer max) {
        if(root == null) return true;
        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}

/*public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return isValid(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    boolean isValid(TreeNode root, int max, int min) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        boolean left = isValid(root.left, root.val, min);
        boolean right = isValid(root.right, max, root.val);
        if (left && right) return true;
        return false;
    }
}*/

// Medium
// Given the root of a binary tree,
// determine if it is a valid binary search tree (BST).

// A valid BST is defined as follows:
// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.

// Example 1:
// Input: root = [2,1,3]
// Output: true

// Example 2:
// Input: root = [5,1,4,null,null,3,6]
// Output: false

// Explanation:
// The root node's value is 5 but its right child's value is 4.


// Constraints:
// The number of nodes in the tree is in the range [1, 104].
// -231 <= Node.val <= 231 - 1

// Solution

/* Definition for a binary tree node.
   public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
    }
 }*/

/*
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, (((long) Integer.MAX_VALUE)  + 1), ((long) Integer.MIN_VALUE) - 1);
    }

    private boolean isValidBSTHelper(TreeNode node, long max, long min) {
        if (node == null) {
            return true;
        }
        if (node.val >= max || node.val <= min) {
            return false;
        }
        return isValidBSTHelper(node.left, node.val, min) && isValidBSTHelper(node.right, max, node.val);
    }
}*/
