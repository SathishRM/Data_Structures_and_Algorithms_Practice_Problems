class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def has_cycle(head):
    node_list =[]
    circle_link = False
    while head != None:
        node_list.append(head)
        head = head.next
        if head in node_list:
            circle_link = True
            break

    return circle_link

def detect_cycle(head: ListNode) -> ListNode:
    slow_pointer = head
    fast_pointer = head
    while fast_pointer != None and fast_pointer.next != None:
        fast_pointer = fast_pointer.next.next
        slow_pointer = slow_pointer.next
        if slow_pointer == fast_pointer:
            break
    else:
        return None

    #Get the starting index of the loop
    slow_pointer = head
    while slow_pointer != fast_pointer:
        slow_pointer = slow_pointer.next
        fast_pointer = fast_pointer.next

    return slow_pointer

def get_intersection_node(headA: ListNode, headB: ListNode) -> ListNode:
    if headA and headB:
        a_pointer = headA
        b_pointer = headB
        iter_count = 0

        while iter_count <= 2:
            if a_pointer == b_pointer:
                return a_pointer

            if a_pointer.next != None:
                a_pointer = a_pointer.next
            else:
                a_pointer = headB
                iter_count += 1

            if b_pointer.next != None:
                b_pointer = b_pointer.next
            else:
                b_pointer = headA
                iter_count += 1

    return None

def remove_nth_from_end(head: ListNode, n: int) -> ListNode:
    dummy_node = ListNode()
    dummy_node.next = head
    delete_pointer = end_pointer = dummy_node
    counter = 0
    while end_pointer != None:
        end_pointer = end_pointer.next
        if counter > n:
            delete_pointer = delete_pointer.next
        counter +=1

    if delete_pointer.next == None:
        return None
    delete_pointer.next = delete_pointer.next.next
    return dummy_node.next

def reverse_list(head: ListNode) -> ListNode:
    if head:
        cur_node = head.next
        first_head = head
        while cur_node != None:
            tmp_node = cur_node.next
            cur_node.next = head
            first_head.next = tmp_node
            head = cur_node
            cur_node = tmp_node

    return head

def remove_elements(head: ListNode, val: int) -> ListNode:
    if head:
        cur_node = head
        while cur_node != None:
            if cur_node.val == val:
                if cur_node == head:
                    head = head.next
                else:
                    pre_node.next = cur_node.next
            else:
                  pre_node = cur_node
            cur_node = cur_node.next

    return head

def odd_even_list(head: ListNode) -> ListNode:
    if head:
        even_head = head.next
        even = even_head
        odd = head

        while even != None and even.next != None:
            odd.next = even.next
            odd = odd.next
            even.next = odd.next
            even = even.next

        odd.next = even_head

    return head

def is_palindrome(head: ListNode) -> bool:
    if head:
        values = []
        while head != None:
            values.append(head.val)
            head = head.next

        for i in range(len(values)):
            if values[i] != values[(i+1) *-1]:
                return False

    return True
