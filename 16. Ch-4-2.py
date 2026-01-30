class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

class BST:
    def __init__(self):
        self.root = None
    def insert(self, data):
        if self.root is None:
            self.root = Node(data)
        else:
            self.insertRecursion(self.root, data)
    def insertRecursion(self, node, data):
        if data < node.data:
            if node.left is None:
                node.left = Node(data)
            else:
                self.insertRecursion(node.left, data)
        else:
            if node.right is None:
                node.right = Node(data)
            else:
                self.insertRecursion(node.right, data)

    def lca(self, node, n1, n2):
        while node:
            if n1 < node.data and n2 < node.data:
                node = node.left
            elif n1 > node.data and n2 > node.data:
                node = node.right
            else:
                return node.data

values = list(map(int, input().split()))
n1, n2 = map(int, input().split())

bst = BST()
for v in values:
    if v != -1:
        bst.insert(v)

result = bst.lca(bst.root, n1, n2)
print(f"The Lowest Common Ancestor of {n1} and {n2} is {result}.")
