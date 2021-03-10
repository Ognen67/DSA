package com.github.ognen67.exercises.lists;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode temp = new ListNode(0);
        ListNode head = temp;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            }
            else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }

        if(l1 != null) {
            head.next = l1;
            l1 = l1.next;
        }

        if(l2 != null) {
            head.next = l2;
            l2 = l2.next;
        }
        return temp.next;
    }

    public static void main(String[] args) {

    }
}
