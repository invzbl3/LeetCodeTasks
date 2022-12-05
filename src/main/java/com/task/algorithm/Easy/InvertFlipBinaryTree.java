package com.task.algorithm.Easy;

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */

/*
    Algorithm description:
    ---------------------
    An inversion, or mirror, of a Binary Tree (T), is just a Binary Tree M(T) whose
    left and right children (of all non-leaf nodes) are swapped.

    Algorithm
    The solution is a simple recursive approach:

    Call invert for left-subtree.
    Call invert for right-subtree.
    Swap left and right subtrees.
 */

// https://www.techiedelight.com/invert-binary-tree-recursive-iterative/
// https://leetcode.com/problems/invert-binary-tree/
// https://www.educative.io/answers/how-to-invert-a-binary-tree
// https://www.baeldung.com/java-reversing-a-binary-tree
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class InvertFlipBinaryTree {
    static boolean isSymmetricUtil(Node root1, Node root2) {
        if (root1 == null || root2 == null)
            return root1 == root2;
        return (root1.data == root2.data) && isSymmetricUtil(root1.left, root2.
                right) && isSymmetricUtil(root1.right, root2.left);
    }

    static boolean isSymmetric(Node root) {
        if (root == null) return true;
        return isSymmetricUtil(root.left, root.right);
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right = new Node(2);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        boolean res;
        res = isSymmetric(root);

        if (res)
            System.out.println("The tree is symmetrical");
        else System.out.println("The tree is NOT symmetrical");

    }
}