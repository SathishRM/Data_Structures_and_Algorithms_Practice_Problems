/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
 */

package linkedlist;

public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode result = mergeKLists(new ListNode[] {
                new ListNode(1, new ListNode(2, new ListNode(4))),
                new ListNode(2, new ListNode(4)),
                new ListNode(1, new ListNode(3, new ListNode(5)))
                });
        while(result!= null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        ListNode mergedLists = new ListNode();
        ListNode head = mergedLists;
        if(len > 0) head.next = lists[0];
        for(int i=1; i<len; i++) {
            head.next = MergeTwoSortedLists.mergeTwoLists(head.next, lists[i]);
        }
        return head.next;
    }
}
