package com.task.algorithm.Easy.solved;

import java.util.HashMap;
import java.util.Stack;

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

    Constraints:

    * 1 <= s.length <= 10^4
    * s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {
    // Idea: use the stack, push the stack when encountering the left parenthesis,
    // and pop the top of the stack when the right parenthesis is encountered,
    // if the top of the stack does not match the current right parenthesis, return false
    public static boolean isValid(String s) {
        HashMap<Character, Character> charMap = new HashMap<>();
        charMap.put('}', '{');
        charMap.put(']', '[');
        charMap.put(')', '(');
        Stack<Character> pareStack = new Stack<>();
        int len = s.length();
        Character item;
        Character top;
        for (int i = 0; i < len; i++) {
            item = s.charAt(i);
            // item is left parenthesis
            if (charMap.containsValue(item)) {
                pareStack.push(item);
            } else {
                // item is the right parenthesis
                // If there is no left parenthesis and only right parentheses,
                // it is judged that the stack is empty,
                // and the top of the stack cannot be executed, then it is unmatched
                if (pareStack.isEmpty()) {
                    return false;
                }
                top = pareStack.pop();
                if (!top.equals(charMap.get(item))) {
                    return false;
                }
            }
        }

        //		if (pareStack.isEmpty()) {
        //			return true;
        //		} else {
        //			return false;
        //		}

        return pareStack.isEmpty();
    }

    // Excellent code example 1
    // Combining my approach with that of example 2, compared to my optimization,
    // it is obviously easier to understand and implement than mine
    /*public boolean isValid1(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c))
                // If the corresponding key value is traversed,
                // the corresponding value is pushed onto the stack to facilitate subsequent comparisons
                stack.push(map.get(c));
                // The perfect combination of two conditions
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }*/

    // Excellent code example 2
    // s.toCharArray() converts a string into an array and then performs foreach traversal,
    // which is more convenient
    /*public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // When traversing to the left parenthesis, push the corresponding right parenthesis onto the stack;
            // When traversing to the right parenthesis (the last if condition),
            // if the current stack is empty, return false; if not empty, pop the top of the stack,
            // if the top element of the stack is not equal to the current element,
            // the parentheses do not match, return false
            // ***Smart move!
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }*/

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String pareStr1 = "{()[()]";
        boolean isValid = isValid(pareStr1);
        System.out.println("\"" + pareStr1 + "\":" + isValid);
        String pareStr2 = "[({})]";
        isValid = isValid(pareStr2);
        System.out.println("\"" + pareStr2 + "\":" + isValid);
        String pareStr3 = "";
        isValid = isValid(pareStr3);
        System.out.println("\"" + pareStr3 + "\":" + isValid);
        String pareStr4 = "})";
        isValid = isValid(pareStr4);
        System.out.println("\"" + pareStr4 + "\":" + isValid);
    }
}

// https://leetcode.com/problems/valid-parentheses/
/*
public class ValidParentheses {

    public static boolean isValid(String s) {
        char[] arr = s.toCharArray();
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
        System.out.println(isValid(str));
        str = "[(])";
        System.out.println(isValid(str));
    }
}*/