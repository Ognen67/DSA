package com.github.ognen67.exercises.lists;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Range {

    static int proveri(int N, int A, int B) {
        long D = 200 * 200 - 4L * (-N);

        if (D < 0) return -1;

        long rez1 = (long) ((200 + Math.floor(Math.sqrt(D))) / 2);
        long rez2 = (long) ((200 - Math.floor(Math.sqrt(D))) / 2);

        rez1 = Math.abs(rez1);
        rez2 = Math.abs(rez2);

        long zbir1 = s(rez1);
        long zbir2 = s(rez2);

        long ravenka1 = (rez1 * rez1 + 200 * rez1 + zbir1);
        long ravenka2 = (rez2 * rez2 + 200 * rez2 + zbir2);

        if (ravenka1 == N) {

            if (rez1 > A && rez1 <= B) {
                return (int) rez1;
            }

        } else if (ravenka2 == N) {

            if (rez2 > A && rez2 <= B)
            return (int) rez2;
        }
        return -1;
    }

    private static int s(long i) {
        int zbir = 0;
        while (i > 0) {
            zbir += i % 10;
            i /= 10;
        }
        return zbir;
    }

    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = (int) Long.parseLong(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = (int) Long.parseLong(st.nextToken());
        int B = (int) Long.parseLong(st.nextToken());

        int res = proveri(N, A, B);
        System.out.println(res);

        br.close();

    }

}
