package com.task.algorithm.Medium.solved;

/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 *
 * s consist of only digits and English letters.
 *
 */
public class LongestPalindromicSubstring {

    static int length = 0;
    // When encountering non-palindrome strings, reduce memory allocation
    // and directly define static final Pair returns to achieve consistency
    static final Pair PAIR = new Pair(1, 1);

    /**
     * Longest Palindrome Algorithm
     * Returns the longest palindrome
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        Pair res = PAIR, leftp = null, rightp = null, tmp = null;
        length = s.length();
        // The length of the string is an even number,
        // directly set the left and right indexes in the middle,
        // and the traversal lengths on both sides are the same
        int right = length / 2, left = right - 1, lenl = 0, lenr = 0;
        if (length % 2 != 0) { // String length is odd
            res = traversal(s, right);
            // First judge the characters in the middle,
            // and then need to traverse the same length on the left and right
            right++;
        }
        // Start in the middle and traverse to both sides
        while (left >= 0 || right < length) {
            leftp = traversal(s, left); // traverse left
            rightp = traversal(s, right); // traverse right
            lenl = leftp.getLen();
            lenr = rightp.getLen();
            tmp = lenl < lenr ? rightp : leftp;
            res = res.getLen() < tmp.getLen() ? tmp : res;
            /**
             * Greedy: When the Pair returned by the current index reaches the boundary, the loop is terminated,
             * and the pointer will not be longer if the pointer is moved to the boundary.
             */
            if (/*lenl > 2 && lenr > 2 && */leftp.left < 1 || rightp.right >= length) { // greedy method
                break;
            }
            left--;
            right++;
        }
        if (res == PAIR) {
            return s.substring(0, 1);
        }
        return s.substring(res.left, res.right);
    }

    /**
     * There are two cases for specifying the index,
     * call the judgeTwo function here
     *
     * @param s
     * @param index
     * @return
     */
    private static Pair traversal(String s, int index) {
        //System.out.println("-----------------------------------\nindex: "+index);
        Pair fir = judgeTwo(s, index - 1, index + 1),
                sec = judgeTwo(s, index, index + 1);
/*        System.out.println("fir: "+fir.left+", "+fir.right);
        System.out.println("sec: "+sec.left+", "+sec.right);*/
        return fir.getLen() < sec.getLen() ? sec : fir;
    }

    /**
     * Specify the left-right comparison index position for palindrome judgment
     *
     * @param s
     * @param left
     * @param right
     * @return
     */
    private static Pair judgeTwo(String s, int left, int right) {
        for (; left >= 0 && right < length; left--, right++) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
        }
        return right - left <= 2 ? PAIR : new Pair(left + 1, right);
    }

    static class Pair {
        int left, right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLen() {
            return right - left;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome(""));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("aa"));
        System.out.println(longestPalindrome("aad"));
        System.out.println(longestPalindrome("daa"));
        System.out.println(longestPalindrome("rrdc"));
        System.out.println(longestPalindrome("dcrr"));
        System.out.println(longestPalindrome("rrdd"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("aacdefcaa"));
        System.out.println(longestPalindrome("fffffggggg"));
        System.out.println(longestPalindrome("asdfghjk"));
    }
}