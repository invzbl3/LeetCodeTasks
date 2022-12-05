package com.task.algorithm.Hard;

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */
/*
class BinaryTreeMaximumPathSum {
    private int sum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        System.out.println(maxPathSum());
    }

    public static int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);

        if (root.left != null) {
            maxPathSumHelper(root.left);

        } else if (root.right != null) {
            maxPathSumHelper(root.right);

        }

        return sum;
    }
    public int  maxPathSumHelper(TreeNode root) {
        if (root ==  null) {
            return 0;
        }

        //check left sum
        int leftValue = root.val + maxPathSumHelper(root.left);

        if (leftValue > sum) {
            sum = leftValue;
        }

        //check right sum
        int rightValue = root.val + maxPathSumHelper(root.right);

        if (rightValue > sum) {
            sum = rightValue;
        }

        //check if root value is greater
        if (root.val > sum) {
            sum = root.val;
        }

        //check if right and left value is the greatest
        if ((leftValue + rightValue - (2 * root.val) ) + root.val > sum) {
            sum = (leftValue + rightValue - (2 * root.val)) + root.val;
        }

        return Math.max(Math.max(leftValue, rightValue), root.val);
    }
}*/
