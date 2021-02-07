package com.github.ognen67.exercises.lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

class SLLNode {
    protected int id;
    protected int plata;
    protected SLLNode succ;

    public SLLNode(int id, int plata, SLLNode succ) {
        this.id = id;
        this.plata = plata;
        this.succ = succ;
    }
}

class SLL {
    private SLLNode first;

    public SLL() {
        // Construct an empty lists.SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNode tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;
    }
    public void insertFirst(int id, int plata) {
        first = new SLLNode(id, plata, first);
    }

    public void insertLast(int id, int plata) {
        if (first != null) {
            SLLNode tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode ins = new SLLNode(id, plata, null);
            tmp.succ = ins;
        } else {
            insertFirst(id, plata);
        }
    }

    public SLLNode getFirst() {
        return first;
    }

    public Iterator<SLLNode> iterator() {
        return new Iterator<SLLNode>() {
            SLLNode current = first;
            @Override
            public boolean hasNext() {
                return current != null && current.succ != null;
            }
            @Override
            public SLLNode next() {
                try {
                    return current;
                } finally {
                    current = current.succ;
                }
            }
        };
    }


    public SLL brisi_pomali_od(int iznos) {
        SLL resultList = new SLL();
        SLLNode curr = this.getFirst();

        while (curr != null) {
            if (curr.plata >= iznos) {
                resultList.insertLast(curr.id, curr.plata);
            }
            curr = curr.succ;
        }
        return resultList;
    }

    public SLL sortiraj_opagacki() {
        SLLNode curr = this.getFirst();
        while (curr != null) {
            SLLNode temp = curr;
            while (temp != null) {
                if (curr.id < temp.id) {
                    swapId(curr, temp);
                    swapPlata(curr, temp);
                }
                temp = temp.succ;
            }
            curr = curr.succ;
        }
        return this;
    }

    private void swapPlata(SLLNode curr, SLLNode temp) {
        int tempPlata;
        tempPlata = curr.plata;
        curr.plata = temp.plata;
        temp.plata = tempPlata;
    }

    private void swapId(SLLNode curr, SLLNode temp) {
        int tempId;
        tempId = curr.id;
        curr.id = temp.id;
        temp.id = tempId;
    }

    public void pecati(SLL lista) {
        SLLNode p = lista.first;
        if (lista.first == null) {
            System.out.println("nema");
        } else {
            while (p != null) {
                System.out.println(p.id + " " + p.plata);
                p = p.succ;
            }

        }
    }

}

public class SLLKompanija {
    public static void main(String[] args) throws IOException {

        SLL lista1 = new SLL();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);

        for (int i = 0; i < N; i++) {
            s = stdin.readLine();
            String s1 = stdin.readLine();
            lista1.insertLast(Integer.parseInt(s), Integer.parseInt(s1));
        }
        s = stdin.readLine();

        lista1 = lista1.brisi_pomali_od(Integer.parseInt(s));
        if (lista1 != null) {
            lista1 = lista1.sortiraj_opagacki();
            lista1.pecati(lista1);
        }

    }
}
