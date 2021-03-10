package com.github.ognen67.exercises.lists;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode root = new ListNode(0);
        ListNode curr = head;
        ListNode prev = root;

        while (curr != null) {
            ListNode tail = curr;
            int listIndex = 0;

            while (curr != null && listIndex < k) {
                curr = curr.next;
                listIndex++;
            }
            if (listIndex != k) {
                prev.next = tail;
            } else {
                prev.next = reverse(tail, k);
                prev = tail;
            }
        }
        return root.next;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null && k-- > 0) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        return head;
    }

    public static void main(String[] args) {

    }
}
