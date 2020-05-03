class MyLinkedList:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.head = None
        self.length = 0

    def get(self, index: int) -> int:
        """
        Get the value of the index-th node in the linked list. If the index is invalid, return -1.
        """
        if index >= self.length:
            #print(self.length)
            return -1
        if self.length > 0:
            cur_node = self.head
            for _ in range(index):
                if cur_node.next != None:
                    cur_node = cur_node.next
            return cur_node.val

    def addAtHead(self, val: int) -> None:
        """
        Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
        """
        #print(f"addAtHead - before insert of {val} , Cur_len - {self.length}")
        node = Node(val)
        if self.head:
            tmp = self.head
            self.head = node
            self.head.next = tmp
        else:
            self.head = node

        self.length += 1
        #print(f"addAtHead - {val} , Cur_len - {self.length}")

    def addAtTail(self, val: int) -> None:
        """
        Append a node of value val to the last element of the linked list.
        """
        if self.head:
            node = Node(val)
            tmp = self.head
            while tmp.next:
                tmp = tmp.next
            tmp.next = node
            node.next = None
            self.length += 1
        else:
            self.addAtHead(val)


    def addAtIndex(self, index: int, val: int) -> None:
        """
        Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
        """
        if index == self.length :
            self.addAtTail(val)
        elif index == 0:
            self.addAtHead(val)
        elif index < self.length:
            cur_node = self.head
            for _ in range(index):
                if cur_node.next != None:
                    pre_node = cur_node
                    cur_node = cur_node.next
            new_node = Node(val)
            pre_node.next = new_node
            new_node.next = cur_node
            self.length += 1


    def deleteAtIndex(self, index: int) -> None:
        """
        Delete the index-th node in the linked list, if the index is valid.
        """
        if index < self.length:
            cur_node = self.head
            pre_node = Node(None)
            if index == 0:
                self.head = cur_node.next
            else:
                for _ in range(index):
                    if cur_node.next != None:
                        pre_node = cur_node
                        cur_node = cur_node.next
                pre_node.next = cur_node.next
            self.length -= 1

class Node:
    def __init__(self,data):
        self.val = data
        self.next = None

# Your MyLinkedList object will be instantiated and called as such:
if __name__ == '__main__':
    obj = MyLinkedList()
    print(obj.get(1))
    print(obj.addAtHead(10))
    print(obj.addAtTail(4))
    print(obj.addAtIndex(1,6))
    print(obj.deleteAtIndex(1))
    print(obj.get(1))
