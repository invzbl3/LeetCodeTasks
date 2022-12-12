package com.task.algorithm.Hard.solved;

/*
    76. Minimum Window Substring

    Given two strings s and t of lengths m and n
    respectively, return the minimum window
    substring of s such that every character in t
    (including duplicates) is included in the window. If
    there is no such substring, return the empty string
    "".

    The testcases will be generated such that the answer
    is unique.

    Example 1:

    Input: s = "ADOBECODEBANC", t =
    "ABC"
    Output: "BANC"
    Explanation: The minimum window
    substring "BANC" includes 'A',
    'B', and 'C' from string t.

    Example 2:

    Input: s = "a", t = "a"
    Output: "a"
    Explanation: The entire string s
    is the minimum window.

    Example 3:

    Input: s = "a", t = "aa"
    Output: ""
    Explanation: Both 'a's from t must
    be included in the window.
    Since the largest window of s only
    has one 'a', return empty string.

    Constraints:

    * m == s.length
    * n == t.length
    * 1 <= m, n <= 10^5
    * s and t consist of uppercase and lowercase
    English letters.

    Follow up: Could you find an algorithm that runs in
    0(m + n) time?
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(str, t));
    }

    public static String minWindow(String s, String t) {
        int[] freq_t = new int[256];
        int[] freq_s = new int[256];

        for (char c : t.toCharArray()) {
            freq_t[c]++;
        }

        int count = 0;
        int min_len = Integer.MAX_VALUE;
        int start_index = -1;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq_s[ch]++;

            if (freq_s[ch] <= freq_t[ch]) {
                count++;
            }

            if (count == t.length()) {

                while ((freq_s[s.charAt(start)] > freq_t[s.charAt(start)] || freq_t[s.charAt(start)] == 0)) {

                    freq_s[s.charAt(start)]--;

                    start++;
                }

                if (min_len > i - start + 1) {
                    min_len = i - start + 1;
                    start_index = start;
                }
            }
        }

        if (start_index == -1) {
            return "";
        }

        return s.substring(start_index, start_index + min_len);
    }
}

/*
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
}*/