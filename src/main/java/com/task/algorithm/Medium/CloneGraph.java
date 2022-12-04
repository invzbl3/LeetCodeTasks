package com.task.algorithm.Medium;

import java.util.*;

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
 */
public class CloneGraph {
    public int val;
    public List<CloneGraph> neighbors;

    public CloneGraph() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public CloneGraph(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public CloneGraph(int _val, List<CloneGraph> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public static CloneGraph cloneGraph_via_BFS(CloneGraph root) {
        Map<CloneGraph,CloneGraph> mapOriginalToCopy = new HashMap<>();
        if(root== null) return null;

        List<Integer> visited = new ArrayList<>();
        Queue<CloneGraph> queue = new LinkedList<>();

        queue.add(root);

        visited.add(root.val);
        CloneGraph clonedRoot = new CloneGraph(root.val);
        mapOriginalToCopy.put(root,clonedRoot);

        while(!queue.isEmpty())
        {
            CloneGraph node = queue.poll();

            for (CloneGraph neighbour:node.neighbors   ) {
                CloneGraph clonedNode = mapOriginalToCopy.get(node);
                if(neighbour != null)
                {
                    CloneGraph clonedNeighbour;
                    if (! visited.contains(neighbour.val))   {
                        visited.add(neighbour.val);
                        queue.add(neighbour);
                        clonedNeighbour = new CloneGraph(neighbour.val);
                        mapOriginalToCopy.put(neighbour,clonedNeighbour);
                    }
                    else   clonedNeighbour =mapOriginalToCopy.get(neighbour);

                    clonedNode.neighbors.add(clonedNeighbour);
                    // mapOriginalToCopy.put(neighbour,clonedNeighbour);
                }
            }
        }
        return clonedRoot;
    }

    public static void main(String[] args)    {
        // Adjaceny list input = [[2,4],[1,3],[2,4],[1,3]]

        CloneGraph node1 = new CloneGraph(1);
        CloneGraph node2 = new CloneGraph(2);
        CloneGraph node3 = new CloneGraph(3);
        CloneGraph node4 = new CloneGraph(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph clonedgraph =  CloneGraph.cloneGraph_via_BFS(node1);
        System.out.println(clonedgraph);
    }
}