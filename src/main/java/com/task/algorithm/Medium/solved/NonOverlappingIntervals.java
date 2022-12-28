package com.task.algorithm.Medium.solved;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  435. Non-overlapping Intervals
 *  https://leetcode.com/problems/non-overlapping-intervals/
 *
 *  Given an array of intervals where intervals[i] = [start(i), end(i)], return the minimum number
 *  of intervals you need to remove to make the rest of the intervals non-overlapping.
 *
 *  Example 1:
 *
 *  Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 *  Output: 1
 *  Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
 *
 *  Example 2:
 *
 *  Input: intervals = [[1,2],[1,2],[1,2]]
 *  Output: 2
 *  Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
 *
 *  Example 3:
 *
 *  Input: intervals = [[1,2],[2,3]]
 *  Output: 0
 *  Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 *
 *  Constraints:
 *
 *  1 <= intervals.length <= 10^5
 *  intervals[i].length == 2
 *  -5 * 10^4 <= start(i) < end(i) <= 5 * 10^4
 */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int counter = 0;
        int[] pre = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (pre[1] > intervals[i][0]) {
                // there is overlapping
                counter++;
                if (pre[1] > intervals[i][1]) {
                    pre = intervals[i];
                }
            } else {
                pre = intervals[i];
            }
        }
        return counter;
    }
}
// [2,4],[1,3] => [1,3],[2,4]