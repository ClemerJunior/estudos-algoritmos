package leetcode;

import leetcode.complement.ListNode;

import static leetcode.AddTwoNumbers.initializeList;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode l1 = initializeList(new int[]{1,2,3,4,5});
        ListNode l2 = initializeList(new int[]{1,2});
        ListNode result = reverseList(l1);

        System.out.println(result);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode reversedList = null;

        while(head != null) {
            ListNode temp = head.next;
            head.next = reversedList;
            reversedList = head;
            head = temp;
        }
        return reversedList;
    }
}
