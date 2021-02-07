package com.github.ognen67.exercises.lists;

public class SLL {

    public class SLLNode {
        protected int id;
        protected int plata;
        protected SLLNode succ;

        public SLLNode(int elem, int plata, SLLNode succ) {
            this.id = elem;
            this.plata = plata;
            this.succ = succ;
        }
    }

    private SLLNode first;

    public SLL() {
        // Construct an empty com.github.ognen67.exercises.lists.kompanija.SLL
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

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode tmp = first;
            ret += tmp + "->";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += tmp + "->";
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(int o, int plata) {
        SLLNode ins = new SLLNode(o, plata, first);
        first = ins;
    }

    public void insertAfter(int o, int plata, SLLNode node) {
        if (node != null) {
            SLLNode ins = new SLLNode(o, plata, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadenot jazol e null");
        }
    }

    public void insertBefore(int o, int plata, SLLNode before) {

        if (first != null) {
            SLLNode tmp = first;
            if(first==before){
                this.insertFirst(o, plata);
                return;
            }
            //ako first!=before
            while (tmp.succ != before)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                SLLNode ins = new SLLNode(o, plata, before);
                tmp.succ = ins;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
    }

    public void insertLast(int o, int plata) {
        if (first != null) {
            SLLNode tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode ins = new SLLNode(o, plata, null);
            tmp.succ = ins;
        } else {
            insertFirst(o, plata);
        }
    }

    public int deleteFirst() {
        if (first != null) {
            SLLNode tmp = first;
            first = first.succ;
            return tmp.id;
        } else {
            System.out.println("Listata e prazna");
            return -1;
        }
    }

    public int delete(SLLNode node) {
        if (first != null) {
            SLLNode tmp = first;
            if(first ==node){
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.id;
            } else {
                System.out.println("Elementot ne postoi vo listata");
                return -1;
            }
        } else {
            System.out.println("Listata e prazna");
            return -1;
        }

    }

    public SLLNode getFirst() {
        return first;
    }

    public SLLNode find(int o) {
        if (first != null) {
            SLLNode tmp = first;
            while (tmp.id != o && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.id == o) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return first;
    }

    public void cut(int iznos) {
        SLLNode curr = first;

        while(curr != null) {
            if(curr.plata < iznos)
                delete(curr);
        }
    }

    public void printList() {
        SLLNode curr = first;
        while (curr != null) {
            System.out.println("asd");
            curr = curr.succ;
        }
    }



}
