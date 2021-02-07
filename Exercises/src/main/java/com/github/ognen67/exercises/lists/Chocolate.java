package com.github.ognen67.exercises.lists;

import java.util.Scanner;

public class Chocolate {

    public static int factorial(int n) {
        if (n == 1 || n == 0) return 1;
        return (n * factorial(n - 1));
    }

    public static void chocolate(int n) {
        int counter = n, sum = 0, k = 0;
        for (int i = 0; i < n && k <= counter; i++) {
            if (counter > k) {
                sum += factorial(counter) / (factorial(k) * factorial(counter - k));
            }
            if (counter == k) {
                sum++;
            }
            k++;
            counter--;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        chocolate(n);
    }
}