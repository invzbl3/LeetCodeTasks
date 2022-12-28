package com.task.algorithm.Medium.solved;

import java.util.*;

/**
 * 207. Course Schedule
 * https://leetcode.com/problems/course-schedule/
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given
 * an array prerequisites where prerequisites[i] = [a(i), b(i)] indicates that you must take course b(i) first
 * if you want to take course a(i).
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 *
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should also have finished course 1. So it is impossible.
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= a(i), b(i) < numCourses
 * All the pairs prerequisites[i] are unique.
 */
public class CourseSchedule {

    public static void main(String[] args) {
        int[][] numbers = diagonalArr();

        System.out.println(canFinish(5, numbers));
    }

    private static int[][] diagonalArr() {
        int[][] diagonalArr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            diagonalArr[i][i] = 9;
            diagonalArr[i][diagonalArr.length - i - 1] = 9;
        }
        return diagonalArr;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            map.computeIfAbsent(prerequisite[1], k -> new HashSet<>()).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> taken = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                taken.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int removed = queue.remove();
            for (Integer dependentCourse : map.getOrDefault(removed, new HashSet<>())) {
                indegree[dependentCourse]--;
                if (indegree[dependentCourse] == 0) {
                    taken.add(dependentCourse);
                    queue.add(dependentCourse);
                }
            }
        }
        return taken.size() == numCourses;
    }
}