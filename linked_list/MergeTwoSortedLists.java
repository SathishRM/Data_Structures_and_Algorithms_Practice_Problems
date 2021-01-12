package linkedlist;
/*
Merge two sorted linked lists and return it as a sorted list.
The list should be made by splicing together the nodes of the first two lists.

Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]

Input: l1 = [], l2 = [0]
Output: [0]
 */

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode result = mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))),
                new ListNode(1, new ListNode(3, new ListNode(4))));
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergedList = new ListNode();
        ListNode head = mergedList;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                mergedList.next = l1;
                l1 = l1.next;
            }
            else {
                mergedList.next = l2;
                l2 = l2.next;
            }
            mergedList = mergedList.next;
        }

        if (l1 != null) {
            mergedList.next = l1;
        }
        if (l2 != null) {
            mergedList.next = l2;
        }
        return head.next;
    }
}
