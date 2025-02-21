package others;

import leetcode.complement.ListNode;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class DeleteRepetedFromLinkedList {

    public static void main(String[] args) {
        ListNode l1 = initializeList(new int[]{1,1,1,2,2,3,4,5});
        ListNode l2 = deleteRepetedFromLinkedList(l1);
        ListNode l3 = deleteRepetedFromLinkedList2(initializeList(new int[]{5}));
        while(l2 != null) {
            System.out.println(l2.val);
            l2 = l2.next;
        }

        while(l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }

    public static ListNode deleteRepetedFromLinkedList(ListNode head) {

        ListNode res = new ListNode(head.val);
        ListNode dummy = res;

        while (head.next != null) {
            head = head.next;
            if (head.val != dummy.val) {
                dummy.next = new ListNode(head.val);
                dummy = dummy.next;
            }
        }
        return res;
    }

    public static ListNode deleteRepetedFromLinkedList2(ListNode head) {

        ListNode res = head;

        while (head !=null && head.next != null) {
            if(head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return res;
    }

    public static ListNode initializeList(int[] args) {
        AtomicReference<ListNode> l1 = new AtomicReference<>();
        Arrays.stream(args).forEach(i -> {
            l1.set(new ListNode(i, l1.get())); });
        return l1.get();
    }
}
