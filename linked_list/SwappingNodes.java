package linkedlist;

/*
You are given the head of a linked list, and an integer k.
Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]

Input: head = [1,2], k = 1
Output: [2,1]
*/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class SwappingNodes {

    public static void main(String[] args) {
        ListNode newList = anotherSwapNodes(new ListNode(10, new ListNode(15)), 1);
        //swapNodes(new ListNode(10, new ListNode(15)), 1);

        while (newList != null) {
            System.out.println(newList.val);
            newList = newList.next;
        }
    }

    public static ListNode swapNodes(ListNode head, int k) {
        int len = 0;
        ListNode tmp = head;

        while (tmp != null) {
            tmp = tmp.next;
            len++;
        }

        ListNode fromFirst = head;
        //1 -> 2 -> 3 -> 4 -> 5
        for (int i =1; i<k; i++) {
            if (fromFirst.next != null) {
                fromFirst = fromFirst.next;
            }
        }

        ListNode fromLast = head;
        for (int i=1; i <= len - k; i++) {
            if(fromLast.next != null) {
                fromLast = fromLast.next;
            }
        }

        int tmpValue = fromFirst.val;
        fromFirst.val = fromLast.val;
        fromLast.val = tmpValue;

        return head;
    }

    //approach-2
    public static ListNode anotherSwapNodes(ListNode head, int k) {
        int len=0;
        ListNode curNode = head, swapNode=null;
        while (curNode != null) {
            len++;
            curNode = curNode.next;
        }
        int i=1;
        curNode = head;
        while (curNode != null) {
            if (i==k || i == len-k+1) {
                if (swapNode != null) {
                    int tmp = swapNode.val;
                    swapNode.val = curNode.val;
                    curNode.val = tmp;
                    break;
                }
                else {
                    swapNode = curNode;
                }
            }
            i++;
            curNode = curNode.next;
        }
        return head;
    }

}
