package com.github.ognen67.exercises.lists;

import java.util.Stack;

class Node {
    int val;
    Node next;
    Node(int val) { this.val = val; }
}

class ReverseLinkedList {


    public Node reverseList(Node head) {
        Stack<Integer> stack = new Stack<>();

        Node curr = head;
        Node asd = head;
        while(curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        curr = head;
        while(curr != null) {
            curr.val = stack.pop();
            curr = curr.next;
        }

        return head;
    }

    public Node reverseList2(Node head) {

        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    void printList(Node head)
    {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public Node reverseList3(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        ReverseLinkedList sol = new ReverseLinkedList();

        Node l1 = new Node(1);
        Node l2 = new Node(2);
        Node l3 = new Node(3);
        Node l4 = new Node(4);
        Node l5 = new Node(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        l1 = sol.reverseList3(l1);

        sol.printList(l1);


    }
}