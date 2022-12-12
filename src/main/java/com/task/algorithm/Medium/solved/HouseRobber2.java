package com.task.algorithm.Medium.solved;

class HouseRobber2 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    private int rob(int[] nums, int start, int end) {
        int prevTwo = 0;
        int prevOne = 0;
        int max = 0;

        for (int i = start; i < end; i++) {
            max = Math.max(prevTwo + nums[i], prevOne);
            prevTwo = prevOne;
            prevOne = max;
        }
        return max;
    }
}