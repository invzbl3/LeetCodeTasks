package com.task.algorithm.Medium.solved;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/
 *
 *  Given an array of distinct integers candidates and a target integer target,
 *  return a list of all unique combinations of candidates where the chosen numbers sum to target.
 *  You may return the combinations in any order.
 *
 *  The same number may be chosen from candidates an unlimited number of times.
 *  Two combinations are unique if the frequency
 *  of at least one of the chosen numbers is different.
 *
 *  The test cases are generated such that the number of unique combinations that sum up to target is less
 *  than 150 combinations for the given input.
 *
 *  Example 1:
 *
 *  Input: candidates = [2,3,6,7], target = 7
 *  Output: [[2,2,3],[7]]
 *  Explanation:
 *  2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 *  7 is a candidate, and 7 = 7.
 *  These are the only two combinations.
 *
 *  Example 2:
 *
 *  Input: candidates = [2,3,5], target = 8
 *  Output: [[2,2,2,2],[2,3,3],[3,5]]
 *
 *  Example 3:
 *
 *  Input: candidates = [2], target = 1
 *  Output: []
 *
 *  Constraints:
 *
 *  * 1 <= candidates.length <= 30
 *  * 2 <= candidates[i] <= 40
 *  * All elements of candidates are distinct.
 *  * 1 <= target <= 40
 */
class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), target, 0, candidates, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> list, int target, int sum, int[] candidates, int index) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
        }

        for (int i = index; i < candidates.length; i++) {
            if (sum > target) break;
            list.add(candidates[i]);
            backtrack(res, list, target, sum + candidates[i], candidates, i);
            list.remove(list.size() - 1);
        }

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

        System.out.println(" ");
    }

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        int[] nums = new int[]{7, 6, 3, 2};
        int target = 7;
        List<List<Integer>> res = solution.combinationSum(nums, target);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer + " ");
            }
            System.out.println(" ");
        }
    }
}