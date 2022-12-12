package com.task.algorithm.Easy.solved;

/*
    Given an array nums containing n distinct numbers
    in the range [0, n], return the only number in the
    range that is missing from the array.

    Example 1:

    Input: nums = [3, 0, 1]
    Output: 2
    Explanation: n = 3 since there are
    3 numbers, so all numbers are in the range [0, 3]. 2 is the missing
    number in the range since it does not appear in nums.

    Example 2:

    Input: nums = [0, 1]
    Output: 2
    Explanation: n = 2 since there are 2 numbers, so all numbers are in
    the range [0,2]. 2 is the missing number in the range since it does
    not appear in nums.

    Example 3:

    Input: nums = [9,6,4,2,3,5,7,0,1]
    Output: 8
    Explanation: n = 9 since there are
    9 numbers, so all numbers are in
    the range [0,9]. 8 is the missing
    number in the range since it does
    not appear in nums.

    Constraints:
    * n == nums.length
    * 1 <= n <= 10^4
    * 0 <= nums[i] <= n
    * All the numbers of nums are unique.

    Follow up: Could you implement a solution using
    only O(1) extra space complexity and O(n)
    runtime complexity?
 */

class MissingNumber {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int expectedSum = ((length)*(length+1))/2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }
}

/*class MissingNumber {
    public int missingNumber(int[] nums) {
        Set<Integer> newSet = new HashSet<>();
        for (int num : nums) {
            newSet.add(num);
        }
        int count = nums.length + 1;

        for (int i = 0; i < count; i++) {
            if (!newSet.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}*/

// Java code to implement the approach
// https://www.geeksforgeeks.org/find-the-missing-number/
/*
class MissingNumber {

    // Function to find the missing number
    public static void findMissing(int[] arr, int N) {
        int i;
        int[] temp = new int[N + 1];
        for (i = 0; i <= N; i++) {
            temp[i] = 0;
        }

        for (i = 0; i < N; i++) {
            temp[arr[i] - 1] = 1;
        }

        int ans = 0;
        for (i = 0; i <= N; i++) {
            if (temp[i] == 0)
                ans = i + 1;
        }
        System.out.println(ans);
    }

    // Driver Code
    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 5, 6, 2};
        int n = arr.length;

        // Function call
        findMissing(arr, n);
    }
}*/