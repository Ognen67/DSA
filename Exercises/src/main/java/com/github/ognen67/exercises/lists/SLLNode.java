package com.github.ognen67.exercises.lists;

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