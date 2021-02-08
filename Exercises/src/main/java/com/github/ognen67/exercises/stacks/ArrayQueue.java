package com.github.ognen67.exercises.stacks;

class ArrayQueue<E>{
    E[] elems;
    int length, front, rear;
    @SuppressWarnings("unchecked")
    public ArrayQueue (int maxlength) {
        elems = (E[]) new Object[maxlength];
        clear();
    }
    public boolean isEmpty () {
        return (length == 0);
    }
    public int size () {
        return length;
    }
    public E peek () {
        if (length > 0)
            return elems[front];
        else{
            System.out.println("Queue is empty");
            return null;
        }
    }
    public void clear () {
        length = 0;
        front = rear = 0;
    }
    public void enqueue (E x) {
        elems[rear++] = x;
        if (rear == elems.length)  rear = 0;
        length++;
    }
    public E dequeue () {
        if (length > 0) {
            E frontmost = elems[front];
            elems[front++] = null;
            if (front == elems.length)  front = 0;
            length--;
            return frontmost;
        } else{
            System.out.println("Queue is empty");
            return null;
        }
    }
}
