package com.task.algorithm.Hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */
public class MinimumWindowSubstring {
    private static String findMinimumWindowSubstring(String s, String t) {
        int n = s.length();

        // length of the minimum window substring (smallest substring of s that has all characters of t)
        int minWindowSubstrLength = Integer.MAX_VALUE;

        // start index of the minimum window substring
        int minWindowSubstrStart = 0;

        // stores the count of each character in the current window
        Map<Character, Integer> windowCharMap = new HashMap<>();

        // stores the count of each character in the string t
        Map<Character, Integer> substrMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            substrMap.put(c, substrMap.getOrDefault(c, 0) + 1);
        }

        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            // Add the next character of the string to the window
            char c = s.charAt(windowEnd);
            windowCharMap.put(c, windowCharMap.getOrDefault(c, 0) + 1);

            // Keep looking for a smaller window while the current window substring contains all the characters of t
            while (containsAll(windowCharMap, substrMap)) {
                if (windowEnd - windowStart + 1 < minWindowSubstrLength) {
                    minWindowSubstrLength = windowEnd - windowStart + 1;
                    minWindowSubstrStart = windowStart;
                }

                // move the leftmost character out of the window
                char leftChar = s.charAt(windowStart);
                windowCharMap.put(leftChar, windowCharMap.get(leftChar) - 1);
                if (windowCharMap.get(leftChar) == 0) {
                    windowCharMap.remove(leftChar);
                }
                // shrink the window
                windowStart++;
            }
        }

        return s.substring(minWindowSubstrStart, minWindowSubstrStart + minWindowSubstrLength);
    }

    private static boolean containsAll(Map<Character, Integer> windowCharMap, Map<Character, Integer> substrMap) {
        for (Map.Entry<Character, Integer> entry : substrMap.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();

            if (!windowCharMap.containsKey(c)) {
                return false;
            }

            if (windowCharMap.get(c) < count) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String s = keyboard.next();
        String t = keyboard.next();
        keyboard.close();

        System.out.printf("Minimum window substring = %s%n", findMinimumWindowSubstring(s, t));
    }
}