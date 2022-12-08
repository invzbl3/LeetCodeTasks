package com.task.algorithm.Medium;

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

class Node2 {
    public int val;
    public List<Node> neighbors;
    public Node2() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public Node2(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }
    public Node2(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class CloneGraph {
    HashSet<Integer> visit = new HashSet<>();
    HashMap<Integer, Node2> copy = new HashMap<>();

    public Node2 cloneGraph(Node2 node2) {
        if (node2 == null) return null;
        Node2 start = new Node2(node2.val);
        copy.put(start.val, start);
        cloneGraph(node2, start);
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