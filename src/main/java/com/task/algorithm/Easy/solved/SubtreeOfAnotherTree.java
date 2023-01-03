package com.task.algorithm.Easy.solved;

/**
 * 572. Subtree of Another Tree
 * https://leetcode.com/problems/subtree-of-another-tree/
 *
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of
 * root with the same structure and node values of subRoot and false otherwise.
 *
 * A subtree of a binary tree is a tree that consists of a node in tree and all of this node's
 * descendants. The tree could also be considered as a subtree of itself.
 *
 * Example 1:
 *
 * Input: root = [3,4,5,1,2], subRoot = [4,1,2]
 * Output: true
 *
 * Example 2:
 *
 * Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot =
 * [4,1,2]
 * Output: false
 *
 * Constraints:

 * The number of nodes in the root tree is in the range [1, 2000].
 * The number of nodes in the subRoot tree is in the range [1, 1000].
 * -10^4 <= root.val <= 10^4
 * -10^4 <= subRoot.val <= 10^4
 *
 * An alternative algorithm description:
 * -------------------------------------
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the
 * same structure and node values of subRoot and false otherwise.
 *
 * A subtree of a binary tree is a tree that consists of a node in tree and all of this node's
 * descendants. The tree could also be considered as a subtree of itself.
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

class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode2 root, TreeNode2 subRoot) {
        if (root != null && subRoot != null) {
            return same(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        } else return root == null && subRoot == null;
    }

    private boolean same(TreeNode2 root, TreeNode2 subRoot) {
        if (root == null && subRoot == null) return true;
        else if (root == null || subRoot == null) return false;
        else {
            if (root.val != subRoot.val) return false;
            return same(root.left, subRoot.left) && same(root.right, subRoot.right);
        }
    }
}

// https://leetcode.com/problems/subtree-of-another-tree/
/*
public class SubtreeOfAnotherTree {

    public boolean equals(Node n1, Node n2) {
        if (n1 == n2) return true;
        if (n1 == null || n2 == null) return false;
        if (n1.data != n2.data) return false; // Should use .equals if Node.data isn't primitive
        return equals(n1.left, n2.left) && equals(n1.right, n2.right);
    }

    public boolean isSubtree(Node n1, Node n2) {
        if (n2 == null) return true;
        if (n1 == null) return false;
        return equals(n1, n2) || isSubtree(n1.left, n2) || isSubtree(n1.right, n2);
    }
}*/