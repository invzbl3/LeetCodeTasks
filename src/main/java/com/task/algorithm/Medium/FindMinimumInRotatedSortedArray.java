package com.task.algorithm.Medium;

public class FindMinimumInRotatedSortedArray {
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
