package com.task.algorithm.Easy.solved;

/**
 * 226. Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * Example 1:
 *
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 *
 * Example 2:
 *
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 *
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 *
 * An alternative algorithm description:
 * -------------------------------------
 * An inversion, or mirror, of a Binary Tree (T), is just a Binary Tree M(T) whose
 * left and right children (of all non-leaf nodes) are swapped.
 *
 * Algorithm
 * The solution is a simple recursive approach:
 *
 * Call invert for left-subtree.
 * Call invert for right-subtree.
 * Swap left and right subtrees.
 */

// https://www.techiedelight.com/invert-binary-tree-recursive-iterative/
// https://leetcode.com/problems/invert-binary-tree/
// https://www.educative.io/answers/how-to-invert-a-binary-tree
// https://www.baeldung.com/java-reversing-a-binary-tree

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
class InvertFlipBinaryTree {
    int val;
    InvertFlipBinaryTree left;
    InvertFlipBinaryTree right;

    InvertFlipBinaryTree() {
    }

    InvertFlipBinaryTree(int val) {
        this.val = val;
    }

    InvertFlipBinaryTree(int val, InvertFlipBinaryTree left, InvertFlipBinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public class Solution {
        public InvertFlipBinaryTree invertTree(InvertFlipBinaryTree root) {
            if (root == null || (root.left == null && root.right == null)) return root;

            // reversing left and right cotyledons
            InvertFlipBinaryTree tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }
}