package com.task.algorithm.Hard.solved;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */

/*
    Algorithm description:
    ---------------------

    The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

    - For example, for arr = [2,3,4], the median is 3.
    - For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
      Implement the MedianFinder class:

      - MedianFinder() initializes the MedianFinder object.
      - void addNum(int num) adds the integer num from the data
        stream to the data structure.
      - double findMedian() returns the median of all elements so far.
        Answers within 10-5 of the actual answer will be accepted.

        Example 1:

        Input
        ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
        [[], [1], [2], [], [3], []]
        Output
        [null, null, null, 1.5, null, 2.0]

        Explanation
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        medianFinder.findMedian();
        // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        medianFinder.findMedian(); // return 2.0

        Constraints:

        * -105 <= num <= 105
        * There will be at least one element in the data structure before
        calling findMedian.
        * At most 5 * 104 calls will be made to addNum and findMedian.


        Follow up:

        If all integer numbers from the stream are in the range [0,
        100], how would you optimize your solution?
        If 99% of all integer numbers from the stream are in the range
        [0, 100], how would you optimize your solution?
 */

class FindMedianFromDataStream {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (minHeap.isEmpty()) {
            minHeap.add(num);
        } else {
            if (minHeap.size() == maxHeap.size()) {
                if (num > maxHeap.peek()) {
                    minHeap.add(num);
                } else {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(num);
                }
            } else {
                if (num < minHeap.peek()) {
                    maxHeap.add(num);
                } else {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(num);
                }
            }
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size() && !maxHeap.isEmpty()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            if (!minHeap.isEmpty())
                return minHeap.peek();
        }
        return 0;
    }

    public static void main(String[] args) {
        FindMedianFromDataStream medianFinder = new FindMedianFromDataStream();
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());
    }
}