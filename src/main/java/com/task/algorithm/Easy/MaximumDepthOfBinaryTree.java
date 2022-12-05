package com.task.algorithm.Easy;

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */
// Java program to find height of tree

// A binary tree node
class Node3 {
    int data;
    Node3 left, right;

    Node3(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node3 root;

    /* Compute the "maxDepth" of a tree -- the number of
       nodes along the longest path from the root node
       down to the farthest leaf node.*/
    int maxDepth(Node3 node) {
        if (node == null)
            return 0;
        else {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node3(1);
        tree.root.left = new Node3(2);
        tree.root.right = new Node3(3);
        tree.root.left.left = new Node3(4);
        tree.root.left.right = new Node3(5);

        System.out.println("Height of tree is "
                + tree.maxDepth(tree.root));
    }
}