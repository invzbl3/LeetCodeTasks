package com.task.algorithm.Medium.solved;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the
 * array nums = [0,1,2,4,5,6,7] might become:
 *
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 *
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1],
 * a[0], a[1], a[2], ..., a[n-2]].
 *
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 *
 * You must write an algorithm that runs in O(log n) time.
 *
 * Example 1:
 *
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 *
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2]
 * Output: 0
 * Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
 *
 * Example 3:
 *
 * Input: nums = [11,13,15,17]
 * Output: 11
 * Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 *
 * All the integers of nums are unique.
 * nums is sorted and rotated between 1 and n times.
 */


/*
 *    Algorithm description:
 *    ---------------------
 *
 *   Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
 *   For example, the array nums = [0,1,2,4,5,6,7] might become:
 *
 *   [4,5,6,7,0,1,2] if it was rotated 4 times.
 *   [0,1,2,4,5,6,7] if it was rotated 7 times.
 *   Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array
 *   [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 *
 *   Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 *
 *   You must write an algorithm that runs in O(log n) time.
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[mid]) {
                if (nums[mid] <= nums[right]) {
                    // all increasing, on left half
                    right = mid - 1;
                } else {
                    // up and down, on right half
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) {
                // must be on left half
                left++;
                right = mid;
            } else {
                // duplicates
                if (left == mid) {
                    return Math.min(nums[left], nums[right]);
                } else {
                    left++;
                }
            }
        }
        return nums[left];
    }
    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray s = new FindMinimumInRotatedSortedArray();
        System.out.format("%d\n", s.findMin(new int[] {4, 5, 6, 7, 0, 1, 2}));
        System.out.format("%d\n", s.findMin(new int[] {2, 1}));
        System.out.format("%d\n", s.findMin(new int[] {3, 1, 2}));
        System.out.format("%d\n", s.findMin(new int[] {4, 5, 1, 2, 3}));
        System.out.format("%d\n", s.findMin(new int[] {3, 3, 1, 3}));
        System.out.format("%d\n", s.findMin(new int[] {1, 3}));
        System.out.format("%d\n", s.findMin(new int[] {1, 3, 3}));
    }
}

/*public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[mid]) {
                if (nums[mid] <= nums[right]) {
                    // all increasing, on left half
                    right = mid - 1;
                } else {
                    // up and down, on right half
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) {
                // must be on left half
                left++;
                right = mid;
            } else {
                // duplicates
                if (left == mid) {
                    return Math.min(nums[left], nums[right]);
                } else {
                    left++;
                }
            }
        }
        return nums[left];
    }
    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray s = new FindMinimumInRotatedSortedArray();
        System.out.format("%d\n", s.findMin(new int[] {4, 5, 6, 7, 0, 1, 2}));
        System.out.format("%d\n", s.findMin(new int[] {2, 1}));
        System.out.format("%d\n", s.findMin(new int[] {3, 1, 2}));
        System.out.format("%d\n", s.findMin(new int[] {4, 5, 1, 2, 3}));
        System.out.format("%d\n", s.findMin(new int[] {3, 3, 1, 3}));
        System.out.format("%d\n", s.findMin(new int[] {1, 3}));
        System.out.format("%d\n", s.findMin(new int[] {1, 3, 3}));
    }
}*/

/*
public class FindMinimumInRotatedSortedArray {

    // Function to find the minimum value
    static int findMin(int[] arr, int n) {
        int min_ele = arr[0];

        // Traversing over array to
        // find minimum element
        for (int i = 0; i < n; i++) {
            if (arr[i] < min_ele) {
                min_ele = arr[i];
            }
        }

        return min_ele;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        int N = arr.length;
        System.out.println(findMin(arr, N));
    }
}*/