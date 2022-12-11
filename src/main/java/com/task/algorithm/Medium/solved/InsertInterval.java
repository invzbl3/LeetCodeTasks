package com.task.algorithm.Medium.solved;

import java.util.*;

class InsertInterval {
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public static int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> res = new ArrayList<>();
    int i = 0;

    while (i < intervals.length && intervals[i][1] < newInterval[0]) {
        res.add(intervals[i++]);
    }

    while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        i++;
    }

    res.add(newInterval);

    while (i < intervals.length) res.add(intervals[i++]);
    int[][] ret = new int[res.size()][];
    for (int z = 0; z < ret.length; z++) {
        ret[z] = res.get(z);
    }

    return ret;
}

    public static void main(String[] args) {
        int[][] intervals = {{0, 5}};
        int[] newInterval = {1, 6};
        int[][] output = insert(intervals, newInterval);

        for (int i = 0; i < intervals.length; i++)
            System.out.print(output[i][0] + " " + output[i][1]);
    }
}

/*
private static boolean overlap(int[] a, int[] b) {
    return (a[0] <= b[0] && b[0] <= a[1]) || (b[0] <= a[0] && a[0] <= b[1]);
}

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int i;
        ArrayList<Integer[]> newIntervals = new ArrayList<>();
        for (i = 0; i < intervals.length; i++)
            if (overlap(intervals[i], newInterval))
                break;
            else
                newIntervals.add(new Integer[]{intervals[i][0], intervals[i][1]});
        if (i < intervals.length) {
            intervals[i][0] = Math.min(intervals[i][0], newInterval[0]);
            intervals[i][1] = Math.max(intervals[i][1], newInterval[1]);
            newIntervals.add(new Integer[]{intervals[i][0], intervals[i][1]});
            int j = i;
            i++;
            for (; i < intervals.length; i++)
                if (overlap(intervals[j], intervals[i])) {
                    int a = Math.min(intervals[j][0], intervals[i][0]);
                    int b = Math.max(intervals[j][1], intervals[i][1]);
                    newIntervals.set(j, new Integer[]{a, b});
                } else
                    newIntervals.add(new Integer[]{intervals[i][0], intervals[i][1]});
            int[][] to_return = new int[newIntervals.size()][2];
            for (i = 0; i < to_return.length; i++) {
                to_return[i][0] = newIntervals.get(i)[0];
                to_return[i][1] = newIntervals.get(i)[1];
            }
            return to_return;
        }
        for (i = 0; i < intervals.length; i++)
            if (newIntervals.get(i)[0] > newInterval[0])
                break;

        newIntervals.add(i, new Integer[]{newInterval[0], newInterval[1]});

        int[][] to_return = new int[newIntervals.size()][2];
        for (i = 0; i < to_return.length; i++) {
            to_return[i][0] = newIntervals.get(i)[0];
            to_return[i][1] = newIntervals.get(i)[1];
        }
        return to_return;
    }

    public static void main(String[] args) {
        int[][] intervals = {{0, 5}};
        int[] newInterval = {1, 6};
        int[][] output = insert(intervals, newInterval);
        for (int i = 0; i < intervals.length; i++)
            System.out.print(output[i][0] + " " + output[i][1]);
    }
}*/