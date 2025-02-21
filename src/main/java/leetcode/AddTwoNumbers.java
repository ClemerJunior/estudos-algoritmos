package leetcode;

import leetcode.complement.ListNode;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = initializeList(new int[]{2,4,3});
        ListNode l2 = initializeList(new int[]{5,6,4});
//        ListNode l1 = new ListNode(5);
//        ListNode l2 = new ListNode(5);
//        ListNode l1 = initializeList(new int[]{9,9,9,9,9,9,9});
//        ListNode l2 = initializeList(new int[]{9,9,9,9});

        ListNode result = addTwoNumbers2(l1, l2);

        System.out.println(result);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sum = l1.val + l2.val;
        int carry = sum / 10;
        ListNode result = new ListNode(sum%10);
        ListNode next1 = l1.next;
        ListNode next2 = l2.next;

        while (next1 != null || next2 != null) {
            int val1 = Objects.isNull(next1) ? 0 : next1.val;
            int val2 =  Objects.isNull(next2) ? 0 : next2.val;
            sum = val1 + val2 + carry;
            carry = sum / 10;
            result = new ListNode(sum%10,result);
            next1 = Objects.isNull(next1) ? null : next1.next;
            next2 = Objects.isNull(next2) ? null : next2.next;
        }

        ListNode finalResult = carry == 1 ? new ListNode(carry) :  new ListNode(result.val);
        while (result.next != null || carry != 0) {
            if(carry == 1) {
                finalResult = new ListNode(result.val, finalResult);
                carry = 0;
            } else {
                result = result.next;
                finalResult = new ListNode(result.val, finalResult);
            }
        }

        return finalResult;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        int total = 0, carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            total = carry;

            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }

            int num = total % 10;
            carry = total / 10;
            dummy.next = new ListNode(num);
            dummy = dummy.next;
        }

        return res.next;
    }

    public static ListNode initializeList(int[] args) {
        AtomicReference<ListNode> l1 = new AtomicReference<>();
        Arrays.stream(args).forEach(i -> {
            l1.set(new ListNode(i, l1.get())); });
        return l1.get();
    }
}
//
//
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
//Example 2:
//
//Input: l1 = [0], l2 = [0]
//Output: [0]
//Example 3:
//
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
//
//
//Constraints:
//
//The number of nodes in each linked list is in the range [1, 100].
//        0 <= Node.val <= 9
//It is guaranteed that the list represents a number that does not have leading zeros.
