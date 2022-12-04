package com.task.algorithm.Medium;

import java.util.*;

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
 */
class PacificAtlanticWaterFlow {

    static int[] x = {0, 0, -1, 1};
    static int[] y = {1, -1, 0, 0};

    static class pair {
        int first;
        int second;

        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // Function to check if coordinate
    // (i, j) lies inside N x M matrix
    static boolean safe(int i, int j, int N, int M) {
        return i >= 0 && j >= 0 && i < N && j < M;
    }

    // Function to perform a BFS
    // Traversal and mark visited
    static void BFS(int[][] matrix, int N, int M,
                    Queue<pair> q,
                    boolean[][] vis) {
        // Loop to traverse q
        while (!q.isEmpty()) {
            // Stores current coordinate
            pair cur = q.peek();
            q.remove();

            // Mark current visited
            vis[cur.first][cur.second] = true;
            for (int i = 0; i < 4; i++) {
                int nx = cur.first + x[i];
                int ny = cur.second + y[i];

                // If coordinate (nx, ny)
                // is inbound and rechable
                if (safe(nx, ny, N, M)
                        && matrix[nx][ny]
                        >= matrix[cur.first]
                        [cur.second]
                        && !vis[nx][ny]) {
                    // Insert into queue
                    q.add(new pair(nx, ny));

                    // Mark visited
                    vis[nx][ny] = true;
                }
            }
        }
    }

    // Function to find the count of
    // valid coordinates
    static int countCoordinates(int[][] mat,
                                int N, int M) {
        // Queue to perform BFS
        Queue<pair> q1 = new LinkedList<>();
        Queue<pair> q2 = new LinkedList<>();

        // Stores the visited coordinates
        // during the 1st traversal

        boolean[][] visited1 = new boolean[N][M];
        // Stores the visited coordinates
        // during the 2nd traversal
        boolean[][] visited2 = new boolean[N][M];

        // Insert the coordinates
        // directly connected
        for (int i = 0; i < M; i++) {
            q1.add(new pair(0, i));
            q2.add(new pair(N - 1, i));
        }
        for (int j = 0; j < N - 1; j++) {
            q1.add(new pair(j + 1, 0));
            q2.add(new pair(j, M - 1));
        }

        // BFS for the 1st ocean
        BFS(mat, N, M, q1, visited1);

        // BFS for the 2nd ocean
        BFS(mat, N, M, q2, visited2);

        // Stores the required count
        int ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // If coordinate (i, j)
                // is reachable from both
                if (visited1[i][j]
                        && visited2[i][j]) {
                    // Update count
                    ans++;
                }
            }
        }

        // Return Answer
        return ans;
    }

    // Driver code
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}};

        System.out.print(countCoordinates(mat, mat[0].length,
                mat[1].length));
    }
}