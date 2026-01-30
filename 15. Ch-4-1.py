class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

class BuildTree:
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

    def is_leaf(self, node):
        return node and not node.left and not node.right
    def left_boundary(self, root, res):
        curr = root.left
        while curr:
            if not self.is_leaf(curr):
                res.append(curr.data)
            curr = curr.left if curr.left else curr.right
    def right_boundary(self, root, res):
        curr = root.right
        temp = []
        while curr:
            if not self.is_leaf(curr):
                temp.append(curr.data)
            curr = curr.right if curr.right else curr.left
        res.extend(temp[::-1])
    def leaf_nodes(self, root, res):
        if not root:
            return
        if self.is_leaf(root):
            res.append(root.data)
            return
        self.leaf_nodes(root.left, res)
        self.leaf_nodes(root.right, res)

    def boundary_traversal(self, root):
        if not root:
            return []
        res = [root.data]
        self.left_boundary(root, res)
        self.leaf_nodes(root.left, res)
        self.leaf_nodes(root.right, res)
        self.right_boundary(root, res)
        return res
arr = list(map(int, input().split()))
bt = BuildTree()
for v in arr:
    if v!=-1:
        bt.insert(v)
result = bt.boundary_traversal(bt.root)
print("Boundary Traversal:", *result)
