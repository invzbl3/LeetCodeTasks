package com.task.algorithm.Medium.solved;

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

public class LowestCommonAncestorOfBST {
    public TreeNode2 lowestCommonAncestor(TreeNode2 root, TreeNode2 p, TreeNode2 q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        return lca(root, min, max);
    }

    private TreeNode2 lca(TreeNode2 root, int min, int max) {
        if (root.val >= min && root.val <= max) {
            return root;
        }
        if (root.val > max) {
            return lca(root.left, min, max);
        }
        return lca(root.right, min, max);
    }
}