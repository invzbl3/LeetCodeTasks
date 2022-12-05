package com.task.algorithm.Easy;

import java.util.*;

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */

/*
    Algorithm description:
    ---------------------


 */

class MeetingRoom {
    //user-defined function to find the minimum number of meeting rooms required
    public static int solve(int[][] intervals) {
        int n = intervals.length;
        //creating arrays of starting and end time
        int[] start = new int[n];
        int[] end = new int[n];
        //loop iterate over the start and end time intervals
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        //sorting starting time array
        Arrays.sort(start);
        //sorting end time array
        Arrays.sort(end);
        int i = 1, j = 0, curr = 1;
        int answer = 1;
        //executes when any both conditions return true
        while (i < start.length && j < end.length) {
            //the condition denotes that the j-th meeting is going on
            if (start[i] < end[j]) {
                //incrementing the meeting room
                curr++;
                //incrementing I because i-th meeting has started
                i++;
            } else {
                //decrements the meeting room by 1 because meeting room is free
                curr--;
                //increments the j-th meeting
                j++;
            }
            //find the max of answer and curr
            answer = Integer.max(answer, curr);
        }
        //returns the minimum number of meeting room required
        return answer;
    }

    //driver code
    public static void main(String[] args) {
        //defining time intervals
        int[][] intervals = {{1, 18}, {18, 23}, {15, 29}, {4, 15}, {2, 11}, {5, 13}};
        System.out.println("Total Number of Meeting room required is: " + solve(intervals));
    }
}