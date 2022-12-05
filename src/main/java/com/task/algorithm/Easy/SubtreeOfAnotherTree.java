package com.task.algorithm.Easy;

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */

/*
    Algorithm description:
    ---------------------
    Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the
    same structure and node values of subRoot and false otherwise.

    A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's
    descendants. The tree tree could also be considered as a subtree of itself.
 */

// https://leetcode.com/problems/subtree-of-another-tree/
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
}