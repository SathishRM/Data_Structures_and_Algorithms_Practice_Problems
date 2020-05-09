class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Travesal:
    def preorder_traversal(self, root: TreeNode) -> list([int]):
        stack_nodes = []
        result = []
        if root:
            stack_nodes.append(root)

            while len(stack_nodes) > 0:
                cur_node = stack_nodes.pop()
                if cur_node.val:
                    result.append(cur_node.val)

                if cur_node.right != None:
                    stack_nodes.append(cur_node.right)

                if cur_node.left != None:
                    stack_nodes.append(cur_node.left)

        return result

    def inorder_traversal(self, root: TreeNode) -> list([int]):
        stack_nodes =[]
        result = []
        if root:
            cur_node = root
            while True:
                if cur_node != None:
                    stack_nodes.append(cur_node)
                    cur_node = cur_node.left
                elif len(stack_nodes) > 0:
                    # print(stack_nodes,len(stack_nodes))
                    cur_node = stack_nodes.pop()
                    # print(cur_node.val)
                    if cur_node.val:
                        result.append(cur_node.val)
                    cur_node = cur_node.right
                else:
                    break

        return result

    def postorder_traversal(self, root: TreeNode) -> list([int]):
        stack_nodes = []
        result =[]
        if root:
            while True:
                while root != None:
                    stack_nodes.append(root)
                    stack_nodes.append(root)
                    root = root.left

                root = stack_nodes.pop()
                if stack_nodes and stack_nodes[-1] == root:
                    root = root.right
                else:
                    if root.val:
                        result.append(root.val)
                    root = None

                if len(stack_nodes) == 0:
                    break

        return result

tree_node2 = TreeNode(3,TreeNode(5),TreeNode(6))
tree_node3 = TreeNode(4,TreeNode(None),TreeNode(1))
tree_node1 = TreeNode(2,tree_node2,tree_node3)
print(tree_node2.val, tree_node2.left.val, tree_node2.right.val)

print(Travesal().preorder_traversal(tree_node1))
print(Travesal().inorder_traversal(tree_node1))
print(Travesal().postorder_traversal(tree_node1))
