package com.github.ognen67.exercises.aipsExamEx;
//
//Спој листи Problem 2 (0 / 0)
//        Дат по еден природен број.
//        Листите се сортирани во растечки редослед. Треба да се спојат двете листи во една така што резултантната листа да е сортирана.
//        Сортирањето е подредување со слевање. Јазлите кои се јавуваат како дупликати (од иста листа или од различна) да се отстранат.
//
//        Во првиот ред од влезот е даден бројот на јазли во првата листа, потоа во вториот ред се дадени броевите од кои се составени
//        јазлите по редослед во првата листа, па во третиот ред е даден бројот на јазли во втората листа, и на крај во четвртиот ред броевите
//        од кои се составени јазлите по редослед во втората листа. На излез треба да се испечатат јазлите по редослед во резултантната споена листа.
//
//        Име на класата (Java): SLLJoinLists
//
//        Забелешка: Да се креира податочна структура еднострано поврзана листа и истата да се искористи во задачата.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SLLJoinLists {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SLL<Integer> lista1 = new SLL<Integer>();
        SLL<Integer> lista2 = new SLL<Integer>();

        System.out.println("enter n");
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            lista1.insertLast(num);
        }
        System.out.println("enter m");
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            lista2.insertLast(num);
        }

        SLLNode<Integer> curr1 = lista1.getFirst();
        SLLNode<Integer> curr2 = lista2.getFirst();
        SLL<Integer> result = new SLL<>();

        while (true) {
            if (curr1.element < curr2.element) {
                result.insertLast(curr1.element);
                curr1 = curr1.succ;
            } else if (curr2.element < curr1.element) {
                result.insertLast(curr2.element);
                curr2 = curr2.succ;
            } else if (curr2.element.equals(curr1.element)) {
                result.insertLast(curr1.element);
                curr1 = curr1.succ;
                curr2 = curr2.succ;
            }
            if (curr1 == null || curr2 == null) {
                break;
            }
        }

        if (curr1 != null) {
            while (curr1 != null) {
                result.insertLast(curr1.element);
                curr1 = curr1.succ;
            }
        }
        if (curr2 != null) {
            while (curr2 != null) {
                result.insertLast(curr2.element);
                curr2 = curr2.succ;
            }
        }

        System.out.println(result);
    }
}
