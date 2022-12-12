package com.task.algorithm.Easy.solved;

/*
    Algorithm description:
    ---------------------
    Given two strings s and t, return true if t is an anagram of s, and false otherwise.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    typically using all the original letters exactly once.

    Example 1:

    Input: s = "anagram", t = "nagaram"
    Output: true
    Example 2:

    Input: s = "rat", t = "car"
    Output: false
 */

// https://www.programcreek.com/2014/05/leetcode-valid-anagram-java/
// https://leetcode.com/problems/valid-anagram/

class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] char_counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char_counts[s.charAt(i) - 'a']++;
            char_counts[t.charAt(i) - 'a']--;
        }

        for (int count : char_counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}

/*class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] char_counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char_counts[s.charAt(i) - 'a']++;
            char_counts[t.charAt(i) - 'a']--;
        }

        for (int count : char_counts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}*/

/*class Solution2 {
    public static boolean isAnagram(String st1, String st2) {
        String s1 = st1.replaceAll("\\s", "");
        String s2 = st2.replaceAll("\\s", "");
        boolean status;
        if (s1.length() != s2.length()) {
            status = false;
        } else {
            char[] arrays1 = s1.toLowerCase().toCharArray();
            char[] arrays2 = s2.toLowerCase().toCharArray();

            Arrays.sort(arrays1);
            Arrays.sort(arrays2);
            status = Arrays.equals(arrays1, arrays2);
        }

        if (status) {
            System.out.println(s1 + ""
                    + " and " + s2 + " are anagrams");
        } else {
            System.out.println(s1 + " and " + s2 + " are not anagrams");
        }
    }

    public static void main(String[] args) {
        isAnagram("keep", "peek");
        isAnagram("MotherInLaw", "HitlerWoman");
    }
}*/

/*
public class ValidAnagram {

    public static boolean solution(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);

            if (!map.containsKey(ch)) {
                return false;
            } else if (map.get(ch) == 1) {
                map.remove(ch);
            } else {
                map.put(ch, map.get(ch) - 1);
            }
        }
        return map.size() == 0;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1, s2));
    }
}*/
