package linkedlist;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

 */

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode result = addTwoNumbers(new ListNode(9),
                new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,
                         new ListNode(9, new ListNode(9,  new ListNode(9, new ListNode(9,
                         new ListNode(9)))))))))));

        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int value, carryOver=0;
        ListNode result = new ListNode();
        ListNode dummyHead = result;

        while (l1 != null || l2 != null || carryOver > 0) {
            if (l1 != null && l2 != null) {
                value = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            else if (l1 != null) {
                value = l1.val;
                l1 = l1.next;
            }
            else if (l2 != null) {
                value = l2.val;
                l2 = l2.next;
            }
            else value = 0;

            result.next = new ListNode((value+carryOver) % 10);
            result = result.next;
            carryOver = (value + carryOver) / 10;
        }
        return dummyHead.next;
    }

}
