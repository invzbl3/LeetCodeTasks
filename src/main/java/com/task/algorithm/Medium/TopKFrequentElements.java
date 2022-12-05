package com.task.algorithm.Medium;

import java.util.*;

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(topKFrequent(nums, 5));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        //count the frequency for each element
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // create a min heap
        PriorityQueue<Map.Entry<Integer, Integer>> queue
                = new PriorityQueue<>(Map.Entry.comparingByValue());

        //maintain a heap of size k.
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        //get all elements from the heap
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().getKey());
        }

        //reverse the order
        Collections.reverse(result);

        return result;
    }
}