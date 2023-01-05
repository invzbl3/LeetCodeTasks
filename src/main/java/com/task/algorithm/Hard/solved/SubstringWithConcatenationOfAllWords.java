package com.task.algorithm.Hard.solved;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 30. Substring with Concatenation of All Words
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 *
 * You are given a string s and an array of strings words. All the strings of words are of the same
 * length.
 *
 * A concatenated substring in s is a substring that contains all the strings of any permutation of
 * words concatenated.
 *
 * For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef",
 * "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a
 * concatenated substring because it is not the concatenation of any permutation of words.
 *
 * Return the starting indices of all the concatenated substrings in s. You can return the answer in
 * any order.
 *
 * Example 1:
 *
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Since words.length == 2 and words[i].length == 3,
 * the concatenated substring has to be of length 6.
 * The substring starting at 0 is "barfoo". It is the concatenation
 * of ["bar","foo"] which is a permutation of words.
 * The substring starting at 9 is "foobar". It is the concatenation
 * of ["foo","bar"] which is a permutation of words.
 * The output order does not matter. Returning [9,0] is fine too.
 *
 * Example 2:
 *
 * Input: s = "wordgoodgoodgoodbestword", words =
 * ["word","good","best","word"]
 * Output: []
 * Explanation: Since words.length == 4 and words[i].length == 4, the
 * concatenated substring has to be of length 16.
 * There is no substring of length 16 is s that is equal to the
 * concatenation of any permutation of words.
 * We return an empty array.
 *
 * Example 3:
 *
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 * Explanation: Since words.length == 3 and words[i].length == 3, the concatenated substring has to be of length 9.
 * The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"] which is a permutation of words.
 * The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"] which is a permutation of words.
 * The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"] which is a permutation of words.
 */
public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indexes = new ArrayList<>();
        Map<String, Long> wrdFreq = Arrays
                .stream(words)
                .collect(Collectors.groupingBy(f -> f, Collectors.counting()));
        Set<String> allWords = Arrays
                .stream(words)
                .collect(Collectors.toSet());
        int lengthOfEachWord = words[0].length();
        int startIndex = 0;
        for (int i = 0; (i + lengthOfEachWord) <= s.length(); i += 1) {
            String strChk = s.substring(i, i + lengthOfEachWord);
            if (allWords.contains(strChk)) {
                if (wrdFreq.containsKey(strChk)) {
                    if (wrdFreq.get(strChk) - 1 <= 0) {
                        wrdFreq.remove(strChk);
                    } else {
                        wrdFreq.put(strChk, wrdFreq.get(strChk) - 1);
                    }
                    i = i + lengthOfEachWord - 1;
                } else {
                    i = startIndex;
                    startIndex = i + 1;
                    wrdFreq = Arrays.stream(words).collect(Collectors.groupingBy(f -> f, Collectors.counting()));
                }
                if (wrdFreq.isEmpty()) {
                    indexes.add(startIndex);
                    i = startIndex;
                    startIndex += 1;
                    wrdFreq = Arrays.stream(words).collect(Collectors.groupingBy(f -> f, Collectors.counting()));
                }
            } else {
                i = startIndex;
                startIndex += 1;
                wrdFreq = Arrays.stream(words).collect(Collectors.groupingBy(f -> f, Collectors.counting()));
            }
        }
        return indexes;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords findSubstring = new SubstringWithConcatenationOfAllWords();
        System.out.println(findSubstring.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo", "barr", "wing", "ding", "wing"}));
        System.out.println(findSubstring.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(findSubstring.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
        System.out.println(findSubstring.findSubstring("aaaaaaaaaaaaaa", new String[]{"aa", "aa"}));
        System.out.println(findSubstring.findSubstring("ababaab", new String[]{"ab", "ba", "ba"}));
        System.out.println(findSubstring.findSubstring("abaababbaba", new String[]{"ab", "ba", "ab", "ba"}));
        System.out.println(findSubstring.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }
}