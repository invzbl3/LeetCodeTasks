package com.task.algorithm.Easy;

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */
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