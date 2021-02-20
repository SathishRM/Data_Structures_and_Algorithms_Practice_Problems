/*
A linked list of length n is given such that each node contains an additional random pointer,
which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
where each new node has its value set to the value of its corresponding original node.
Both the next and random pointer of the new nodes should point to new nodes in the copied list such that
the pointers in the original list and copied list represent the same list state.
None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y,
then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes.
Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to,
or null if it does not point to any node.
Your code will only be given the head of the original linked list.

Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 */
package linkedlist;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node second = new Node(6);
        Node third = new Node(3);
        Node fourth = new Node(1);
        head.next = second;
        head.random = null;
        second.next = third;
        second.random = fourth;
        third.next = fourth;
        third.random = head;
        fourth.random = third;

        Node curNode = head;

        while (curNode != null) {
            System.out.println(curNode.val + " - " + curNode );
            if (curNode.random != null) System.out.println("Random-" + curNode.random.val);
            curNode = curNode.next;

        }

        head = copyRandomList(head);
        while (head != null) {
            System.out.println(head.val + " - " + head);
            if(head.random != null) System.out.println("Random - " + head.random.val);
            head = head.next;
        }
    }

    public static Node copyRandomList(Node head) {

        Node curNode = head, temp;
        while (curNode != null) {
            temp = curNode.next;
            curNode.next = new Node(curNode.val);
            curNode.next.next = temp;
            curNode = curNode.next.next;
        }

        curNode = head;
        while (curNode != null) {
            if (curNode.random != null) {
                curNode.next.random = curNode.random.next;
            }
            curNode = curNode.next.next;
        }
        curNode = head;
        if (curNode != null) head = curNode.next;
        while (curNode != null && curNode.next != null) {
            temp = curNode.next;
            curNode.next = curNode.next.next;
            if (curNode.next != null)  temp.next = curNode.next.next;
            curNode = curNode.next;
        }
        return head;
    }
}
