package com.github.ognen67.exercises.lists;

import java.util.Scanner;

public class PodeliSporedProsek {

    public static void main(String[] args) {
        DLL<Integer> lista = new DLL<>();

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        ;
        for (int i = 0; i < n; i++) {
            lista.insertLast(input.nextInt());
        }

        DLLNode<Integer> curr = lista.getFirst();
        long suma = 0;
        int c = 0;

        while (curr != null) {
            suma += curr.element;
            c++;
            curr = curr.succ;
        }

        int average = (int) (suma / c);

        DLL<Integer> podProsek = new DLL<>();
        DLL<Integer> nadProsek = new DLL<>();

        curr = lista.getFirst();
        while (curr != null) {
            if (curr.element <= average) {
                podProsek.insertLast(curr.element);
            } else {
                nadProsek.insertLast(curr.element);
            }
            curr = curr.succ;
        }

        System.out.println(podProsek.toString());
        System.out.println(nadProsek.toString());
    }
}
