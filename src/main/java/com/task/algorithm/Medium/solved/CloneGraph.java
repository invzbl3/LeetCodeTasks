package com.task.algorithm.Medium.solved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
 */

class CloneGraph {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    HashSet<Integer> visit = new HashSet<>();
    HashMap<Integer, Node> copy = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node start = new Node(node.val);
        copy.put(start.val, start);
        cloneGraph(node, start);
        return start;
    }

    public void cloneGraph(Node initial, Node clone) {
        if (visit.contains(initial.val)) return;
        visit.add(initial.val);

        for (Node next : initial.neighbors) {
            Node same;
            if (!copy.containsKey(next.val)) {
                same = new Node(next.val);
                copy.put(same.val, same);
            } else {
                same = copy.get(next.val);
            }
            clone.neighbors.add(same);
            cloneGraph(next, same);
        }
    }
}