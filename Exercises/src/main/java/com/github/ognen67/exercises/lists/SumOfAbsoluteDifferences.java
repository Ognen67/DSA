package com.github.ognen67.exercises.lists;

import java.util.ArrayList;
import java.util.Arrays;

class SumOfAbsoluteDifferences {
    static int solve(int[] numbers, int N, int K) {
        int max = 0;
        int[] result = new int[N-1];

        for (int i = 0; i < N-1; i++) {
            if (numbers[i] != getMax(numbers, N)) {
                result[i] = (getMax(numbers, N) - numbers[i]);
            }
        }

        for (int i : result) {
            System.out.print(i + " ");
        }

        int tmp;
        for(int i=0; i<N-1; i++) {
            for (int j = 0; j < N-1; j++) {
                if (result[i] > result[j]) {
                    tmp = result[i];
                    result[i] = result[j];
                    result[j] = tmp;
                }
            }
        }

        int sum=0;
        for(int i=0; i<K-1; i++) {
            sum+=result[i];
        }

        System.out.println(Arrays.toString(result));


        return sum;
    }

    static int getMax(int[] numbers, int N) {
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        int i, j, k;
        int[] numbers = { 1,0,2,4,0,1,9,3,6,8 };

        int res = solve(numbers, 10, 5);
        System.out.println(res);
    }
}
