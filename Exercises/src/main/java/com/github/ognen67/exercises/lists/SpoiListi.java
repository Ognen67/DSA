package com.github.ognen67.exercises.lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpoiListi {


    public static void main(String[] args) throws IOException {
        DLL<Integer> lista1 = new DLL<Integer>();
        DLL<Integer> lista2 = new DLL<Integer>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista1.insertLast(Integer.parseInt(pomniza[i]));
        }

        s = stdin.readLine();
        N = Integer.parseInt(s);
        s = stdin.readLine();
        pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista2.insertLast(Integer.parseInt(pomniza[i]));
        }

        DLL<Integer> result = new DLL<Integer>();
        DLLNode<Integer> curr1 = lista1.getFirst();
        DLLNode<Integer> curr2 = lista2.getLast();

        while (curr1 != null || curr2 != null) {
            if (curr1 != null) {
                if (curr1.element % 2 == 0) {
                    result.insertLast(curr1.element);
                }
                curr1 = curr1.succ;
            }

            if (curr2 != null) {
                if (curr2.element % 2 == 0) {
                    result.insertLast(curr2.element);
                }
                curr2 = curr2.pred;
            }
        }

        curr1 = lista1.getFirst();
        curr2 = lista2.getLast();

        while (curr1 != null) {
            if (curr1 != null) {
                if (curr1.element % 2 != 0) {
                    result.insertLast(curr1.element);
                }
                curr1 = curr1.succ;
            }
        }

        while(curr2 != null) {
            if (curr2 != null) {
                if (curr2.element % 2 != 0) {
                    result.insertLast(curr2.element);
                }
                curr2 = curr2.pred;
            }
        }

        System.out.println(result.toString());
    }
}
