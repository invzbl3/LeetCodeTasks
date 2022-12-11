package com.task.algorithm.Medium.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */

/*
    56. Merge Intervals

    Given an array of intervals where intervals[i]
    = [start(i), end(i)], merge all overlapping intervals,
    and return an array of the non-overlapping intervals
    that cover all the intervals in the input.

    Example 1:

    Input: intervals = [[1,3],[2,6],
    [8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3]
    and [2,6] overlap, merge them into
    [1,6].

    Example 2:

    Input: intervals = [[1,4],[4,5]]
    Output: [[1,5]]
    Explanation: Intervals [1,4] and
    [4,5] are considered overlapping.

    Constraints:

    1 <= intervals.length <= 10^4
    intervals[i].length == 2
    0 <= start(i) <= end(i) <= 10^4
 */
public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals,
                Comparator.comparingInt(arr -> arr[0]));

        List<int[]> output_arr = new ArrayList();
        int[] current_interval = intervals[0];
        output_arr.add(current_interval);

        for (int[] interval : intervals) {
            int current_end = current_interval[1];
            int next_begin = interval[0];
            int next_end = interval[1];

            if (current_end >= next_begin) {
                current_interval[1] = Math.max(current_end, next_end);
            } else {
                current_interval = interval;
                output_arr.add(current_interval);
            }
        }
        return output_arr.toArray(new int[output_arr.size()][]);
    }
}