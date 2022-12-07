package com.task.algorithm.Easy;

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */

/*
    Algorithm description:
    ---------------------
    Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

    According to the definition of LCA on Wikipedia: "The lowest common ancestor is defined
    between two nodes p and q as the lowest node in T that has both p and q as descendants
    (where we allow a node to be a descendant of itself)."
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class LowestCommonAncestorOfBST {
    public SameTree.TreeNode lowestCommonAncestor(SameTree.TreeNode root, SameTree.TreeNode p, SameTree.TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        return lca(root, min, max);
    }

    private SameTree.TreeNode lca(SameTree.TreeNode root, int min, int max) {
        if (root.val >= min && root.val <= max) {
            return root;
        }
        if (root.val > max) {
            return lca(root.left, min, max);
        }
        return lca(root.right, min, max);
    }
}