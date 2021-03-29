/*
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:
begin to intersect at node c1.
A :      a1 -> a2
                |-> c1 -> c2 -> c3
B: b1 -> b2 -> b3

Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Each value on each linked list is in the range [1, 10^9].
Your code should preferably run in O(n) time and use only O(1) memory.
 */
package linkedlist;

import java.sql.SQLOutput;

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode intersectNode = new ListNode(2,new ListNode(4));
        ListNode headA = new ListNode(1,new ListNode(9, new ListNode(1,intersectNode)));
        ListNode headB = new ListNode(3,intersectNode);

        ListNode result = getIntersectionNode(headA, headB);

        System.out.println(intersectNode.toString() + " result node - " + result  );
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        while (pointerA != pointerB) {

            if (pointerA != null) pointerA = pointerA.next;
            else pointerA = headB;

            if (pointerB != null) pointerB = pointerB.next;
            else pointerB = headA;
        }
        return pointerA;
    }
}
