package com.github.ognen67.exercises.lists;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (ListNode list : lists) {
            while (list != null) {
                queue.add(list.val);
                list = list.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while(!queue.isEmpty()) {
            head.next = new ListNode(queue.remove());
            head = head.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {


    }
}
