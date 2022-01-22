/*
Given the head of a singly linked list and two integers left and right where left <= right, 
reverse the nodes of the list from position left to position right, and return the reversed list.

Example 1:
1 -> 2 -> 3 -> 4 -> 5
1 -> 4 -> 3 -> 2 -> 5
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Example 2:
Input: head = [5], left = 1, right = 1
Output: [5]
 
Constraints:
The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
*/

package linkedlist

object ReverseLinkedListII extends App{

  val head: ListNode = new ListNode(1, new ListNode(2,
    new ListNode(3, new ListNode(4, new ListNode(5)))))
  var result: ListNode = reverseBetween(head, 2, 5)
  while (result != null) {
    println(result.x)
    result = result.next
  }

  def reverseBetween(head: ListNode, left: Int, right: Int): ListNode = {
    if (left == right) head
    else {
      var i: Int = 1
      var leftBefore: ListNode = null
      var leftNode: ListNode = null
      var preNode: ListNode = null
      var curNode = head

      while (curNode != null && i <= right) {
        if (i == left) {
          leftBefore = if (left > 1) preNode else null
          leftNode = curNode
        }
        else if (i == right) {
          if (leftBefore != null) leftBefore.next = curNode
          leftNode.next = curNode.next
        }

        val tmp: ListNode = curNode.next
        if (i> left) curNode.next = preNode
        preNode = curNode
        curNode = tmp
        i += 1
      }

      if (left == 1) preNode else head
    }
  }

  class ListNode(_x: Int = 0, _next: ListNode = null) {
       var next: ListNode = _next
       var x: Int = _x
  }
}
