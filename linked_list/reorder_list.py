'''
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
You may not modify the values in the list's nodes, only nodes itself may be changed.

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
'''

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def reorder_list(head: ListNode) -> None:
    """
    Do not return anything, modify head in-place instead.
    """
    if head:
        nodes = [head]
        while head.next:
            nodes.append(head.next)
            head = head.next

        left_ind = 0
        right_ind = len(nodes) - 1

        while left_ind < right_ind:

            tmp = nodes[left_ind].next
            nodes[left_ind].next = nodes[right_ind]
            nodes[right_ind].next = tmp
            left_ind += 1
            right_ind -= 1
        nodes[left_ind].next = None

four = ListNode(val=4, next=None)
third = ListNode(val=3, next=four)
sec = ListNode(val=2, next=third)
head = ListNode(val=1, next=sec)

reorder_list(head)
print(head.next.val)
