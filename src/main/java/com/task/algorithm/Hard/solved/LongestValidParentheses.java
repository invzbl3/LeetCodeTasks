package com.task.algorithm.Hard.solved;

import java.util.Stack;

/**
 * 32. Longest Valid Parentheses
 * https://leetcode.com/problems/longest-valid-parentheses/
 *
 * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed)
 * parentheses substring.
 *
 * Example 1:
 *
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 *
 * Example 2:
 *
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 *
 * Example 3:
 *
 * Input: s = ""
 * Output: 0
 *
 * Constraints:
 *
 * * 0 <= s.length <= 3 * 104
 * * s[i] is '(', or ')'.
 */
public class LongestValidParentheses {

    /**
     * Define a start variable to record the starting position of the legal bracket string, traverse the string,
     * if the left bracket is encountered, the subscript will be pushed onto the stack;
     * if the right bracket is encountered, if the stack is empty, the next
     * The coordinate position is recorded to start.
     * If the stack is not empty, the top element of the stack is taken out.
     * If the stack is empty, the result and the maximum value of i - start + 1 are updated;
     * if the stack is not empty,
     * Then update the result and i - the larger value in stack.peek().
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();

        int res = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();

                    res = stack.isEmpty() ? Math.max(res, i - start + 1) : Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        String s = "()(()";
        int size = longestValidParentheses.longestValidParentheses(s);
        System.out.println(size);
    }
}