package com.task.algorithm.Medium.solved;

import java.util.*;

/**
 *  252. Meeting Rooms
 *  https://leetcode.com/problems/meeting-rooms/
 *
 *  Given an array of meeting time intervals where
 *  intervals[i] = [start(i), end(i)], determine if a person
 *  could attend all meetings.
 *
 *  Example 1:
 *
 *  Input: intervals = [[0, 30], [5, 10], [15, 20]]
 *  Output: false
 *
 *  Example 2:
 *
 *  Input: intervals = [[7, 10], [2, 4]]
 *  Output: true
 *
 *  Constraints:
 *
 *  * 0 <= intervals.length <= 10^4
 *  * intervals[i].length == 2
 *  * 0 <= start(i) < end(i) <= 10^6
 *
 *  Algorithm description:
 *  ---------------------
 *  It is a very interesting problem frequently asked in interviews of top IT companies like Google, Amazon,
 *  TCS, Accenture, Adobe, Apple, Infosys, etc. By solving the problem, one wants to check the logical
 *  ability, critical thinking, and problem-solving skill of the interviewee. So, in this section,
 *  we are going to find minimum number of meeting rooms required problem in Java with different approaches
 *  and logic. Also, we will create Java programs for the same.
 */
class Solution2 {
    public boolean canAttendMeetings(int[][] intervals) {
        // base case
        int n = intervals.length;
        if(n == 0) return true;

        // Sort array by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // return false if there is overlapping
        for (int i = 0; i < n - 1; i++) {
            int[] meeting1 = intervals[i];
            int[] meeting2 = intervals[i + 1];
            if(meeting1[1] > meeting2[0]) {
                return false;
            }
        }
        return true;
    }
}

/*
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            // sort array by the start time
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

            // min heap to keep track of the end time
            PriorityQueue<integer> minHeap = new PriorityQueue<>();

            // find min rooms
            minHeap.add(intervals[0]);
            for(int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if(minHeap.peek() <= cur[0]) {
                minHeap.poll();
            }
            minHeap.add(cur[1]);
        }
        // return min rooms
        return minHeap.size();
    }
}*/

// https://www.javatpoint.com/minimum-number-of-meeting-room-required-problem-in-java
/*
class MeetingRooms {
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
        int i = 1;
        int j = 0;
        int curr = 1;
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
}*/