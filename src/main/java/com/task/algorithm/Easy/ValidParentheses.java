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


 */

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