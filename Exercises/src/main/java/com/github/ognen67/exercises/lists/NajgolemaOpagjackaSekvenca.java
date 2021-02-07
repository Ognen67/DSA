package com.github.ognen67.exercises.lists;

import java.util.Scanner;


public class NajgolemaOpagjackaSekvenca {


    private static int najdolgaOpagackaSekvenca(int[] a) {

        int br = 1;
        int temp = 1;

        if(a.length == 1) {
            return 1;
        }

        for (int i = 0; i < a.length; i++) {
            if (i != a.length-1 && a[i] > a[i + 1]) {
                temp++;
            }
            else if(i == a.length-1) {
                if (a[i] < a[i - 1]) {
                    temp++;
                }
                else {
                    if(temp > br) {
                        br = temp;
                    }
                    temp = 1;
                }
            }

            else if (a[i] < a[i + 1]) {
                if(temp > br) {
                    br = temp;
                }
                temp = 1;
            }
        }

        return br;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = stdin.nextInt();
        }

        System.out.println(najdolgaOpagackaSekvenca(a));
    }


}
