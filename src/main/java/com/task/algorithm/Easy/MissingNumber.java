package com.task.algorithm.Easy;

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
 */

/*
    Algorithm description:
    ---------------------


 */

// Java code to implement the approach
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
}