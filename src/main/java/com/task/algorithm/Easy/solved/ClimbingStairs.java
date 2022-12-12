package com.task.algorithm.Easy.solved;

/*
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb
 * to the top?
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * Constraints:
 * 
 * 1 <= n <= 45
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int current = 0;
        int prev1 = 2;
        int prev2 = 1;
        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}

/*    public static void main(String[] args) {
        System.out.println(climbStairs());
    }

    public static int climbStairs() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.print("How many steps there are: ");
        try {
            scan.close();
            if (n <= 2) {
                System.out.printf("There are %d distinct ways to climb %d steps", n, n);
            } else {
                int step1 = 1;
                int step2 = 2;
                for (int i = 3; i < n; i++) {
                    int temp = step2;
                    step2 += step1;
                    step1 = temp;
                }
                System.out.printf("There are %d distinct ways to climb %d steps", step1 + step2, n);
            }
        } catch (Exception e) {
            System.out.println("You need to enter a integer number!");
        }
        return n;
    }*/

/*
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int current = 0;
        int prev1 = 2;
        int prev2 = 1;
        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}*/