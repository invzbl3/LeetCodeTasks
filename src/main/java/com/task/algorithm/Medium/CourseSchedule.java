package com.task.algorithm.Medium;

import java.util.*;

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
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