package com.github.ognen67.exercises.lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DLLVojska {


    public static void main(String[] args) throws IOException {
        DLL<Integer> lista = new DLL<Integer>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] ids = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(ids[i]));
        }

        s = stdin.readLine();
        String interval[] = s.split(" ");
        int a = Integer.parseInt(interval[0]);
        int b = Integer.parseInt(interval[1]);

        s = stdin.readLine();
        interval = s.split(" ");
        int c = Integer.parseInt(interval[0]);
        int d = Integer.parseInt(interval[1]);


        DLL<Integer> result = vojska(lista, a, b, c, d);


        DLLNode<Integer> node = result.getFirst();
        System.out.print(node.element);
        node = node.succ;
        while (node != null) {
            System.out.print(" " + node.element);
            node = node.succ;
        }

    }

    private static void deleteNode(DLL<Integer> list, DLLNode<Integer> del) {
        DLLNode<Integer> curr = list.getFirst();

        while(curr != null) {
            if(list.getFirst() == null || del == null) {
                return;
            }

            if(list.getFirst() == del) {
                list.getFirst().succ = del.succ;
            }

            if(curr.element == del.element) {
                if(del.pred != null) {
                    del.pred.succ = del.succ;
                }
                if(del.succ != null) {
                    del.succ.pred = del.pred;
                }
            }
            curr = curr.succ;
        }
    }


    private static DLL<Integer> vojska(DLL<Integer> lista, int a, int b, int c, int d) {

        DLLNode<Integer> curr = lista.getFirst();
        DLL<Integer> interval1 = new DLL<Integer>();
        DLL<Integer> interval2 = new DLL<Integer>();

        DLLNode<Integer> aPred = lista.getFirst();
        DLLNode<Integer> cPred = lista.getFirst();

        while (curr != null) {

            if (curr.element == a) {
                while (curr.element != b) {
                    if(interval1.getFirst() == null) {
                        aPred = curr.pred;
                    }
                    interval1.insertLast(curr.element);
                    deleteNode(lista, curr);
                    curr = curr.succ;
                }
                interval1.insertLast(curr.element);
                deleteNode(lista, curr);
            }

            if (curr.element == c) {
                while (curr.element != d) {
                    if(interval2.getFirst() == null) {
                        cPred = curr.pred;
                    }
                    interval2.insertLast(curr.element);
                    deleteNode(lista, curr);
                    curr = curr.succ;
                }
                    interval2.insertLast(curr.element);
                    deleteNode(lista, curr);
            }
            curr = curr.succ;
        }


        curr = lista.getFirst();



        while(curr!=null)
        {
            if(curr.element == aPred.element) {
                DLLNode<Integer> temp = interval2.getFirst();
                while(temp != null) {
                    lista.insertAfter(temp.element, curr);
                    temp = temp.succ;
                    curr = curr.succ;
                }
            }
            curr = curr.succ;
        }

        curr = lista.getFirst();

        while(curr!=null)
        {
            if(curr.element == cPred.element) {
                DLLNode<Integer> temp = interval1.getFirst();
                while(temp != null) {
                    lista.insertAfter(temp.element, curr);
                    temp = temp.succ;
                    curr = curr.succ;
                }
            }
            curr = curr.succ;
        }

        System.out.println(aPred.element + " " + cPred.element);

        return lista;
    }

}
