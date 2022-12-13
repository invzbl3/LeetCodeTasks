package com.task.algorithm.Medium.solved;

import java.util.*;

/*
 * 417. Pacific Atlantic Water Flow
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 *
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean.
 * The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the
 * island's right and bottom edges.
 *
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix
 * heights where heights[r][c] represents the height above sea level of the cell at
 * coordinate (r, c).
 *
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north,
 * south, east, and west if the neighboring cell's height is less than or equal to the current cell's
 * height. Water can flow from any cell adjacent to an ocean into the ocean.
 *
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain
 * water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 *
 * Example 1:
 *
 * Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],
 * [6,7,1,4,5],[5,1,1,2,4]]
 * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * Explanation: The following cells can flow to the Pacific and
 * Atlantic oceans, as shown below:
 * [0,4]: [0,4] -> Pacific Ocean
 *        [0,4] -> Atlantic Ocean
 * [1,3]: [1,3] -> [0,3] -> Pacific Ocean
 *        [1,3] -> [1,4] -> Atlantic Ocean
 * [1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean
 *        [1,4] -> Atlantic Ocean
 * [2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean
 *        [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
 * [3,0]: [3,0] -> Pacific Ocean
 *        [3,0] -> [4,0] -> Atlantic Ocean
 * [3,1]: [3,1] -> [3,0] -> Pacific Ocean
 *        [3,1] -> [4,1] -> Atlantic Ocean
 * [4,0]: [4,0] -> Pacific Ocean
 *        [4,0] -> Atlantic Ocean
 *
 * Example 2:
 *
 * Input: heights = [[1]]
 * Output: [[0,0]]
 * Explanation: The water can flow from the only cell to the Pacific
 * and Atlantic oceans.
 *
 * Constraints:
 *
 * m == heights.length
 * n == heights[r].length
 * 1 <= m, n <= 200
 * 0 <= heights[r][c] <= 10^5
 */
class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            pacificAtlantic(heights, i, n - 1, atlantic);
            pacificAtlantic(heights, i, 0, pacific);
        }
        for (int i = 0; i < n; i++) {
            pacificAtlantic(heights, m - 1, i, atlantic);
            pacificAtlantic(heights, 0, i, pacific);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }
        }
        return result;
    }

    public void pacificAtlantic(int[][] heights, int x, int y, boolean[][] visit) {
        if (!visit[x][y]) {
            visit[x][y] = true;
            if (x - 1 >= 0 && !visit[x - 1][y] && heights[x][y] <= heights[x - 1][y]) {
                pacificAtlantic(heights, x - 1, y, visit);
            }
            if (y - 1 >= 0 && !visit[x][y - 1] && heights[x][y] <= heights[x][y - 1]) {
                pacificAtlantic(heights, x, y - 1, visit);
            }
            if (x + 1 < heights.length && !visit[x + 1][y] && heights[x][y] <= heights[x + 1][y]) {
                pacificAtlantic(heights, x + 1, y, visit);
            }
            if (y + 1 < heights[x].length && !visit[x][y + 1] && heights[x][y] <= heights[x][y + 1]) {
                pacificAtlantic(heights, x, y + 1, visit);
            }
        }
    }
}

/*
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
}*/