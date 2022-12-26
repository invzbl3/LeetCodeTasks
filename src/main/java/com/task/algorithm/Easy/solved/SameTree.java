package com.task.algorithm.Easy.solved;

/**
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or
 * not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have
 * the same value.
 *
 * Example 1:
 *
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 *
 * Example 2:
 *
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 *
 * Example 3:
 *
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 *
 * Constraints:
 *
 * The number of nodes in both trees is in the range [0, 100].
 * -10^4 <= Node.val <= 10^4
 *
 *
 * An alternative algorithm description:
 * -------------------------------------
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *       1
 *      / \
 *     2   2
 *    / \ / \
 *   3  4 4  3
 *
 * But the following [1, 2, 2, null, 3, null, 3] is not:
 *
 *       1
 *      / \
 *     2   2
 *     \   \
 *     3    3
 *
 * Note: Bonus points if you could solve it both recursively and iteratively.
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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

/*
public class SameTree {
    public static class TreeNode {

        int val;

        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        boolean left = true;
        boolean right = true;

        if (p != null && q != null) {
            if (p.val == q.val) {
                left = isSameTree(p.left, q.left);
                right = isSameTree(p.right, q.right);
            } else {
                return false;
            }
        } else {
            return p == null && q == null;
        }

        return left && right;
    }

    public boolean isSameTree_1(TreeNode p, TreeNode q) {

        List<Integer> listp = new ArrayList<>();
        List<Integer> listq = new ArrayList<>();

        Stack<TreeNode> stackp = new Stack<>();
        Stack<TreeNode> stackq = new Stack<>();

        TreeNode nodep = p;
        TreeNode nodeq = q;

        while (nodep != null || !stackp.isEmpty()) {
            while (nodep != null) {
                listp.add(nodep.val);
                stackp.push(nodep);
                nodep = nodeq.left;
            }

            if (!stackp.isEmpty()) {
                nodep = stackp.pop();
                nodep = nodep.right;
            }
        }

        while (nodeq != null || !stackq.isEmpty()) {
            while (nodeq != null) {
                listq.add(nodeq.val);
                stackq.push(nodeq);
                nodeq = nodeq.left;
            }
            if (!stackq.isEmpty()) {
                nodeq = stackq.pop();
                nodeq = nodeq.right;
            }
        }

        return listp == listq;
    }

    public boolean isSameTree_2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree_2(p.left, q.left) && isSameTree_2(p.right, q.right);
        }
    }

    public boolean isSameTree_3(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            if (node1.val != node2.val) {
                return false;
            }

            TreeNode left1 = node1.left;
            TreeNode right1 = node1.right;
            TreeNode left2 = node2.left;
            TreeNode right2 = node2.right;

            if (left1 == null ^ left2 == null) {
                return false;
            }

            if (right1 == null ^ right2 == null) {
                return false;
            }

            if (left1 != null) {
                queue1.offer(left1);
            }

            if (right1 != null) {
                queue1.offer(left2);
            }

            if (left2 != null) {
                queue2.offer(left2);
            }

            if (right2 != null) {
                queue2.offer(right2);
            }
        }

        return queue1.isEmpty() && queue2.isEmpty();
    }
}*/