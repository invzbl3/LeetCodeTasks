package com.task.algorithm.Hard.solved;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 68. Text Justification
 * https://leetcode.com/problems/text-justification/
 *
 * Given an array of strings words and a width maxWidth, format the text such that each line has
 * exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in
 * each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces
 * on a line does not divide evenly between words, the empty slots on the left will be assigned
 * more spaces than the slots on the right.
 *
 * For the last line of text, it should be left-justified, and no extra space is inserted between words.
 *
 * Note:
 *
 * * A word is defined as a character sequence consisting of non-space characters only.
 * * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * * The input array words contains at least one word.
 *
 * Example 1:
 *
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 *
 * Example 2:
 *
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of
 * "shall     be", because the last line must be left-justified
 * instead of fully-justified.
 * Note that the second line is also left-justified because it
 * contains only one word.
 *
 * Example 3:
 *
 * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 * Constraints:
 *
 * * 1 <= words.length <= 300
 * * 1 <= words[i].length <= 20
 * * words[i] consists of only English letters and symbols.
 * * 1 <= maxWidth <= 100
 * * words[i].length <= maxWidth
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        if (words == null || words.length == 0) {
            return list;
        }

        LinkedList<String> stack = new LinkedList<>();

        int lineLength = 0;

        for (String word : words) {
            if (word.length() > maxWidth) {
                return new ArrayList<>();
            }
            if (lineLength + word.length() < maxWidth) {
                stack.add(word);
                lineLength += word.length() + 1;
            } else if (lineLength + word.length() == maxWidth) {
                StringBuilder str = new StringBuilder(word);
                if (stack.isEmpty()) {
                    int padding = maxWidth - str.length();
                    str.append(" ".repeat(Math.max(0, padding)));
                } else {
                    while (!stack.isEmpty()) {
                        str.insert(0, stack.pollLast() + " ");
                    }
                }
                list.add(str.toString());
                lineLength = 0;
            } else {
                print(maxWidth, list, stack, lineLength);
                stack.push(word);
                lineLength = word.length() + 1;
            }
        }

        StringBuilder last = new StringBuilder();
        while (!stack.isEmpty()) {
            last.append(stack.pop()).append(" ");
        }
        if (last.length() != 0) {
            last.deleteCharAt(last.length() - 1);
            int padding = maxWidth - last.length();
            last.append(" ".repeat(Math.max(0, padding)));
            list.add(last.toString());
        }
        return list;
    }

    private void print(int maxWidth, List<String> list,
                       LinkedList<String> stack, int lineLength) {
        if (!stack.isEmpty()) {
            if (stack.size() == 1) {
                StringBuilder word = new StringBuilder(stack.pop());
                int padding = maxWidth - word.length();
                word.append(" ".repeat(Math.max(0, padding)));
                list.add(word.toString());
            } else {
                int len = lineLength - stack.size();
                int spaceNum = maxWidth - len;
                int baseLine = spaceNum / (stack.size() - 1);
                int minorSlots = spaceNum % (stack.size() - 1);

                StringBuilder str;
                StringBuilder spaces = new StringBuilder();
                spaces.append(" ".repeat(Math.max(0, baseLine)));
                str = new StringBuilder(stack.pollFirst());
                while (!stack.isEmpty()) {
                    if (minorSlots > 0) {
                        str.append(" ");
                    }
                    str.append(spaces).append(stack.pollFirst());
                    minorSlots--;
                }
                list.add(str.toString());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new TextJustification().fullJustify(
                new String[] { "You", "never", "know", "what", "you're",
                        "gonna", "get." }, 20));
        System.out.println(new TextJustification().fullJustify(
                new String[] { "Listen", "to", "many,", "speak", "to", "a",
                        "few." }, 6));
        System.out.println(new TextJustification().fullJustify(
                new String[] { "This", "is", "an", "example", "of", "text",
                        "justification." }, 16));
        System.out.println(new TextJustification().fullJustify(
                new String[] { "What", "must", "be", "shall", "be." }, 12));
        System.out.println(new TextJustification().fullJustify(
                new String[] { "Listen", "to", "many,", "speak", "to", "a",
                        "few." }, 6));
        System.out.println(new TextJustification().fullJustify(
                new String[] { "a", "b", "c", "d", "e" }, 3));
        System.out.println(new TextJustification().fullJustify(
                new String[] { "a" }, 2));
        System.out.println(new TextJustification().fullJustify(
                new String[] { "" }, 3));
        System.out.println(new TextJustification().fullJustify(
                new String[] { "  " }, 3));
    }
}