package com.github.ognen67.exercises.aipsExamEx;

public class DeleteNodeInDLL {


    public static void main(String[] args) {
        DLL<Integer> dll = new DLL<>();

        dll.insertLast(1);
        dll.insertLast(2);
        dll.insertLast(3);
        dll.insertLast(4);
        dll.insertLast(5);

        DLLNode<Integer> del = dll.find(1);

        deleteNodeFromDLL(dll, del);

        System.out.println(dll);
    }

    static void deleteNodeFromDLL(DLL<Integer> dll, DLLNode<Integer> del) {

        if(dll.getFirst() == null || del == null) {
            return;
        }

        if(dll.getFirst() == del) {
            dll.getFirst().succ = del.succ;
        }

        if(del.succ != null) {
            del.succ.pred = del.pred;
        }

        if(del.pred != null) {
            del.pred.succ = del.succ;
        }
    }
}
