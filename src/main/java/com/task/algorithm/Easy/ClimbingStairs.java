package com.task.algorithm.Easy;

import java.util.Scanner;

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
 */

/*
    Algorithm description:
    ---------------------
    You are climbing a staircase that has n steps. You can take the steps either 1 or 2 at a time.
    Calculate how many distinct ways you can climb to the top of the staircase.

    Example:

    For n = 1, the output should be climbingStairs(n) = 1;
    For n = 2, the output should be climbingStairs(n) = 2.
    You can either climb 2 steps at once or climb 1 step two times.

    Input/Output
    [execution time limit] 3 seconds (java)
    [input] integer n
    Guaranteed constraints: 1 ≤ n ≤ 50.
    [output] integer
    It's guaranteed that the answer will fit in a 32-bit integer.
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("How many steps there are: ");
        try {
            int n = scan.nextInt();
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
    }
}

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