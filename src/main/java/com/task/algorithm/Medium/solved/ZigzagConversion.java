package com.task.algorithm.Medium.solved;

/**
 * 6. Zigzag Conversion
 * https://leetcode.com/problems/zigzag-conversion/
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may
 * want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 *
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 *
 * Constraints:
 *
 * * 1 <= s.length <= 1000
 * * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * * 1 <= numRows <= 1000
 */
public class ZigzagConversion {

    public static String convert(String s, int numRows) {
        if (s.isEmpty()) return "";
        if (numRows <= 1) return s;

        int _numRows = Math.min(s.length(), numRows);
        return convert(s,
                new String[_numRows], _numRows - 1, 0, true);
    }

    public static String convert(String s, String[] zigzag, int numRows, int currentRow, boolean isDownDirection) {
        if (s.isEmpty()) return String.join("", zigzag);

        // down && reach bottom O => up, currentRow - 1
        // down && reach bottom X => down, currentRow + 1
        // up && first reached O => down, currentRow + 1
        // up && first reached X => up, currentRow - 1
        String nextS = s.substring(1);
        String[] nextZigzag = getNextZigzag(s, zigzag, currentRow);
        if (isDownDirection) {
            if (numRows == currentRow) {
                int nextRow = currentRow - 1;
                return convert(nextS, nextZigzag, numRows, nextRow, false);
            } else {
                int nextRow = currentRow + 1;
                return convert(nextS, nextZigzag, numRows, nextRow, true);
            }
        } else {
            if (0 == currentRow) {
                int nextRow = currentRow + 1;
                return convert(nextS, nextZigzag, numRows, nextRow, true);
            } else {
                int nextRow = currentRow - 1;
                return convert(nextS, nextZigzag, numRows, nextRow, false);
            }
        }
    }

    public static String[] getNextZigzag(String s, String[] zigzag, int currentRow) {
        if (zigzag[currentRow] == null || zigzag[currentRow].isEmpty()) {
            zigzag[currentRow] = s.substring(0, 1);
        } else {
            zigzag[currentRow] += s.substring(0, 1);
        }
        return zigzag;
    }
}