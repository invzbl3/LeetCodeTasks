package com.task.algorithm.Medium.solved;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */

/*
    347. Top K Frequent Elements

    Given a non-empty array of integers, return the k most frequent elements.

    Example 1:

    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]

    Example 2:

    Input: nums = [1], k = 1
    Output: [1]

    Constraints:

    1 <= nums.length <= 10^5
    * -10^4 <= nums[i] <= 10^4
    * k is in the range [1, the number of unique elements in the array].
    * It is guaranteed that the answer is unique.

    Follow up: Your algorithm's time complexity must be better than O(n
    log n), where n is the array's size.

    Note:

    * You may assume k is always valid, 1 <= k <= number of unique elements.
    * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
    * It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
    * You can return the answer in any order.
 */

class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        pq.addAll(map.entrySet());

        int[] output = new int[k];
        for (int i = 0; i < k; i++) {
            output[i] = Objects.requireNonNull(pq.poll()).getKey();
        }
        return output;
    }
}

/*
public class TopKFrequentElements {

    public static int[] intersection(int[] nums1, int[] nums2) {

        Set hashSet = new HashSet();
        Map<String, Integer> map = new HashMap();
        map.put("len", 0);
        int[] re = new int[Math.max(nums1.length, nums2.length)];
        Arrays.stream(nums1).forEach(hashSet::add);
        Arrays.stream(nums2).distinct().forEach(item ->
                {
                    int index = 0;
                    if (hashSet.contains(item)) {
                        re[map.get("len")] = item;
                        index++;
                    }
                    map.put("len", map.get("len") + index);
                }
        );
        // 将re中初始化为0的位置去除
        return Arrays.copyOf(re, map.get("len"));
    }

    public static boolean isHappy(int n) {
        // Write your code here
        if (n == 1) {
            return true;
        }
        if (n < 1) {
            return false;
        }
        int count = 0;
        while (n != 1) {
            String s = n + "";
            char[] arr = s.toCharArray();
            int sum = 0;
            for (char c : arr) {
                sum += Integer.parseInt(c + "") * Integer.parseInt(c + "");
            }
            n = sum;
            count++;
            if (count > 1000) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIsomorphic(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.indexOf(ch1[i]) != t.indexOf(ch2[i])) {
                return false;
            }
        }
        return true;
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (!map.containsKey(i + j)) {
                        map.put(i + j, new ArrayList<>());
                    }
                    map.get(i + j).add(list1[i]);
                }
            }
        }

        int minIndexSum = Integer.MAX_VALUE;
        for (int key : map.keySet()) {
            minIndexSum = Math.min(minIndexSum, key);
        }

        String[] res = new String[map.get(minIndexSum).size()];
        return map.get(minIndexSum).toArray(res);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) {
            return false;
        }
        if (n <= 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.get(nums[i]) != null && (i - map.get(nums[i])) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> map = new HashMap<>();
        List<TreeNode> list = new ArrayList<>();
        dlr(root, map, list);
        return list;
    }

    public String dlr(TreeNode node, Map<String, Integer> map, List<TreeNode> list) {

        if (node == null) {
            return "";
        }
        String str = node.val + "(" + dlr(node.right, map, list) + ")" + "(" + dlr(node.left, map, list) + ")";

        if (map.containsKey(str)) {
            if (map.get(str) == 1) {
                list.add(node);
            }
            map.put(str, map.get(str) + 1);
        } else {
            map.put(str, 1);
        }
        return str;
    }

    public static int numJewelsInStones(String j, String s) {
        char[] js = j.toCharArray();
        char[] ss = s.toCharArray();
        int count = 0;
        for (char c : js) {
            for (char value : ss) {
                if (c == value) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : a) {
            for (int i : b) {
                int sumab = value + i;
                if (map.containsKey(sumab)) {
                    map.put(sumab, map.get(sumab) + 1);
                } else {
                    map.put(sumab, 1);
                }
            }
        }

        for (int k : c) {
            for (int i : d) {
                int sumcd = -(k + i);
            }
        }
    }

    public static List<Integer> topkfrequent(int[] nums, int k) {

        // 统计元素的频次
        Map<Integer, Integer> int2FreqMap = new HashMap<>(16);
        for (int num : nums) {
            int2FreqMap.put(num, int2FreqMap.getOrDefault(num, 0) + 1);
        }

        // 桶排序
        List[] bucket = new List[nums.length + 1];
        for (Integer key : int2FreqMap.keySet()) {
            int freq = int2FreqMap.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        // 逆序（频次由高到低）取出元素
        List<Integer> ret = new ArrayList<>();
        for (int i = nums.length; i >= 0 && ret.size() < k; --i) {
            if (bucket[i] != null) {
                ret.addAll(bucket[i]);
            }
        }
        return ret;
    }

    static class RandomizedSet {
        HashSet<Integer> set;

        */
/**
         * Initialize your data structure here.
         *//*

        public RandomizedSet() {
            set = new HashSet<>();
        }

        */
/**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         *//*

        public boolean insert(int val) {
            return set.add(val);
        }

        */
/**
         * Removes a value from the set. Returns true if the set contained the specified element.
         *//*

        public boolean remove(int val) {
            return set.remove(val);
        }

        */
/**
         * Get a random element from the set.
         *//*

        public int getRandom() {
            Object[] list = set.toArray();
            int length = list.length;
            int index = (int) (Math.random() * length);
            return (Integer) list[index];
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));

        String s = "aab";
        String t = "ccb";
        System.out.println(isIsomorphic(s, t));

        int[] nums = {1, 2, 3, 1};
        int k = 3;
        containsNearbyDuplicate(nums, k);
        String j = "aA";
        String abbbb = "aAAbbbb";
        System.out.println(numJewelsInStones(j, abbbb));
        int[] a = {1, 2};
        int[] b = {-2, -1};
        int[] c = {-1, 2};
        int[] d = {0, 2};

        fourSumCount(a, b, c, d);

        int[] nums11 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        topkfrequent(nums11, k1);
    }
}*/
