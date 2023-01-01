package com.task.algorithm.Hard.solved;

/**
 * 4. Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted
 * arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 * Constraints:
 *
 * * nums1.length == m
 * * nums2.length == n
 * * 0 <= m <= 1000
 * * 0 <= n <= 1000
 * * 1 <= m + n <= 2000
 * * -106 <= nums1[i], nums2[i] <= 106
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        boolean ji = ((len1 + len2) % 2) > 0;
        int mid = ji ? (len1 + len2) / 2 + 1 : (len1 + len2) / 2;
        if (ji)
            return kthElement(nums1, nums2, mid);
        else {
            double mid1 = kthElement(nums1, nums2, mid);
            double mid2 = kthElement(nums1, nums2, mid + 1);
            return (mid1 + mid2) / 2;
        }
    }

    public int kthElement(int[] nums1, int[] nums2, int k) {
        int lastIdx1 = nums1.length - 1, lastIdx2 = nums2.length - 1;
        int index1 = 0, index2 = 0;
        while (true) {
            if (lastIdx1 < index1) {
                return nums2[index2 + k - 1];
            }
            if (lastIdx2 < index2) {
                return nums1[index1 + k - 1];
            }
            int half = k / 2 == 0 ? 1 : k / 2;
            int newIdx1 = Math.min(index1 + half - 1, lastIdx1);
            int newIdx2 = Math.min(index2 + half - 1, lastIdx2);
            if (nums1[newIdx1] <= nums2[newIdx2]) {
                if (k == 1) {
                    return nums1[newIdx1];
                }
                k -= (newIdx1 - index1 + 1);
                index1 = newIdx1 + 1;

            } else {
                if (k == 1) {
                    return nums2[newIdx2];
                }
                k -= (newIdx2 - index2 + 1);
                index2 = newIdx2 + 1;
            }

        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays findMedianSortedArrays = new MedianOfTwoSortedArrays();

        double i = findMedianSortedArrays.findMedianSortedArrays(new int[]{1, 2, 4, 5, 7, 8, 10},
                new int[]{0, 1, 2, 3, 6, 7, 9, 12, 15});
        System.out.println(i);
        i = findMedianSortedArrays.findMedianSortedArrays(new int[]{1},
                new int[]{});
        System.out.println(i);
    }
}