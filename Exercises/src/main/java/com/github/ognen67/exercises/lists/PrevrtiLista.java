package com.github.ognen67.exercises.lists;


import java.util.Scanner;

public class PrevrtiLista {

    public static void prevrtiIPecati(DLL<Integer> dll) {
        // 5 3 2 8 5 9
        DLLNode<Integer> node = dll.getLast(); // 9
        DLL<Integer> reversed = new DLL<Integer>();

        for (int i = 0; i < dll.length(); i++) {
            if (node.element % 2 == 0) {
                reversed.insertLast(node.element);
            }
            node = node.pred;
        }

        node = dll.getLast();

        for (int i = 0; i < dll.length(); i++) {
            if (node.element % 2 != 0) {
                reversed.insertLast(node.element);
            }
            node = node.pred;
        }

        DLLNode<Integer> curr = reversed.getFirst();

        while (curr != null) {
            System.out.print(curr.element + "<->");
            curr = curr.succ;
        }
    }

    public static void main(String[] args) {
        DLL<Integer> dll = new DLL<Integer>();

        Scanner input = new Scanner(System.in);
        int n;
        n = input.nextInt();
        for (int i = 0; i < n; i++) {
            dll.insertLast(input.nextInt());
        }


        prevrtiIPecati(dll);
    }
}