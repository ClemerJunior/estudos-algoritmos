package leetcode;

import leetcode.complement.ListNode;

import static leetcode.AddTwoNumbers.initializeList;

public class LinkedLists {

    public static void main(String[] args) {
        ListNode l1 = initializeList(new int[]{1});
        ListNode l2 = initializeList(new int[]{5,3,2});

//        ListNode l1 = initializeList(new int[]{9,6,5});
//        ListNode l2 = initializeList(new int[]{8,7,4,3,2,1});

//        ListNode l1 = initializeList(new int[]{5,4,3,2,1});
//        ListNode l2 = initializeList(new int[]{4,2,1});

        ListNode result = mergeTwoSortedLists(l1, l2);

        System.out.println(result);
    }

    public static ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummy = new ListNode(0);
        ListNode mergedList = dummy;

        while(list1 != null) {
            while(list2 != null && list2.val <= list1.val) {
                dummy.next = new ListNode(list2.val);
                dummy = dummy.next;
                list2 = list2.next;
            }
            dummy.next = new ListNode(list1.val);
            dummy = dummy.next;
            list1 = list1.next;
        }

        while(list2 != null) {
            dummy.next = new ListNode(list2.val);
            dummy = dummy.next;
            list2 = list2.next;
        }

        return mergedList.next;
    }
}
