package com.github.ognen67.exercises.lists;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bus {

    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        br.close();

        System.out.println(minimalno(N, M));
        System.out.println(maksimalno(N, M));
    }

    private static int maksimalno(int N, int M) {
        return M==0 ? N*100 : (N + M - 1) * 100;
    }

    private static int minimalno(int N, int M) {
        return N>=M ? N*100 : (M-N)*100 + N*100;
    }
}
