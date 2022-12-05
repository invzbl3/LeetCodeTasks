package com.task.algorithm.Easy;

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
 */

/*
    Algorithm description:
    ---------------------
    Sum of Two Numbers in Java

    In Java, finding the sum of two or more numbers is very easy.
    First, declare and initialize two variables to be added.
    Another variable to store the sum of numbers. Apply mathematical operator (+) between the declared
    variable and store the result.
    The following program calculates and prints the sum of two numbers.
 */

// https://www.javatpoint.com/sum-of-numbers-in-java#:~:text=Sum%20of%20Two%20Numbers%20in,variable%20and%20store%20the%20result.
public class SumOfTwoIntegers {

    public static void main(String[] args) {

        System.out.println("Enter two numbers");
        int first = 10;
        int second = 20;

        System.out.println(first + " " + second);

        // add two numbers
        int sum = first + second;
        System.out.println("The sum is: " + sum);
    }
}