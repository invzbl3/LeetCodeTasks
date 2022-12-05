package com.task.algorithm.Easy;

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */
public class SameTree {
    public static void main(String[] args) {
        SameTree same = new SameTree();

        TreeNode first = new TreeNode(3);
        first.left = new TreeNode(6);
        first.right = new TreeNode(9);

        TreeNode second = new TreeNode(3);
        second.left = new TreeNode(9);
        second.right = new TreeNode(6);

        boolean result = same.isSameTree(first, second);
        System.out.println(result);
    }

    public boolean isSameTree(TreeNode first, TreeNode second) {

        if (first == null && second == null) {
            return true;
        }

        if ((first == null || second == null) || first.val != second.val) {
            return false;
        }

        if (!isSameTree(first.left, second.left)) {
            return false;
        }

        return isSameTree(first.right, second.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}