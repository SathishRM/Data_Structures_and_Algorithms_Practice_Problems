class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def swapPairs(head: ListNode) -> ListNode:
    if head == None:
        return None
    elif head.next == None:
        return head
    else:
        next_node = head.next
        head.next = swapPairs(next_node.next)
        next_node.next = head
        return next_node

def print_ll(head: ListNode) -> str:
    result = ''
    while head:
        result += str(head.val) + '->'
        head = head.next
    return result.strip('->')

four = ListNode(val=4, next=None)
third = ListNode(val=3, next=four)
sec = ListNode(val=2, next=third)
head = ListNode(val=1, next=sec)

print(print_ll(head))
head = swapPairs(head)
print(print_ll(head))