package com.task.algorithm.Medium;

// The longest common subsequence in Java
public class LongestCommonSubsequence {
    static void lcs(String S1, String S2, int m, int n) {
        int[][] LCS_table = new int[m + 1][n + 1];

        // Building the matrix in bottom-up way
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    LCS_table[i][j] = 0;
                else if (S1.charAt(i - 1) == S2.charAt(j - 1))
                    LCS_table[i][j] = LCS_table[i - 1][j - 1] + 1;
                else
                    LCS_table[i][j] = Math.max(LCS_table[i - 1][j], LCS_table[i][j - 1]);
            }
        }

        int index = LCS_table[m][n];
        int temp = index;

        char[] lcs = new char[index + 1];
        lcs[index] = '\0';

        int j = n;
        while (m > 0 && j > 0) {
            if (S1.charAt(m - 1) == S2.charAt(j - 1)) {
                lcs[index - 1] = S1.charAt(m - 1);
            }
        }
    }
}