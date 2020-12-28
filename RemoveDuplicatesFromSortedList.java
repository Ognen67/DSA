import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesFromSortedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode curr = head;
        while(curr != null && curr.next != null) {
            if(curr.next.val == curr.val) {
                curr.next = curr.next.next;
            }
            else
                curr = curr.next;
        }
        return head;
    }

    public int sumOfList(ListNode head) {
        int sum = 0;
        if(head == null)
            return 0;
        else return sum += head.val + sumOfList(head.next);
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        RemoveDuplicatesFromSortedList r = new RemoveDuplicatesFromSortedList();
        ListNode first = r.deleteDuplicates(l1);

        while(first != null) {
            System.out.println(first.val);
            first = first.next;
        }

        System.out.println(r.sumOfList(first));



    }
}
