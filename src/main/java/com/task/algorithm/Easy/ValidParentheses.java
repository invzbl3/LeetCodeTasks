package com.task.algorithm.Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */

/*
    Algorithm description:
    ---------------------
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    determine if the input string is valid.

    An input string is valid if:

    1. Open brackets must be closed by the same type of brackets.
    2. Open brackets must be closed in the correct order.
    3. Every close bracket has a corresponding open bracket of the same type.

    Example 1:

    Input: s = "()"
    Output: true

    Example 2:

    Input: s = "()[]{}"
    Output: true

    Example 3:
    Input: s = "(]"
    Output: false
 */

// https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {

    public static boolean checkParenthesis(String str) {
        char[] arr = str.toCharArray();
        List<String> list = new ArrayList<>();

        for (char c : arr) {
            if (c == '{' || c == '(' || c == '[') {
                list.add(Character.toString(c));
            } else {
                if (c == '}') {
                    if (list.get(list.size() - 1).equals("(") || list.get(list.size() - 1).equals("[")) {
                        return false;
                    } else {
                        list.remove(list.size() - 1);
                    }
                } else if (c == ']') {
                    if (list.get(list.size() - 1).equals("(") || list.get(list.size() - 1).equals("{")) {
                        return false;
                    } else {
                        list.remove(list.size() - 1);
                    }
                } else if (c == ')') {
                    if (list.get(list.size() - 1).equals("[") || list.get(list.size() - 1).equals("{")) {
                        return false;
                    } else {
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "[()]{}{[()()]()}";
        System.out.println(checkParenthesis(str));
        str = "[(])";
        System.out.println(checkParenthesis(str));
    }
}