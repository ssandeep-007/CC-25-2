class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

class BuildTree:
    def __init__(self):
        self.idx = 0

    def buildTree(self, arr):
        if self.idx >= len(arr):
            return None
        if arr[self.idx] == -1:
            self.idx += 1
            return None
        root = Node(arr[self.idx])
        self.idx += 1
        root.left = self.buildTree(arr)
        root.right = self.buildTree(arr)
        return root

    def maxDepth(self, node):
        if node is None:
            return 0
        left_depth = self.maxDepth(node.left)
        right_depth = self.maxDepth(node.right)

        return 1 + max(left_depth, right_depth)


arr = list(map(int, input().split()))
bt = BuildTree()
root = bt.buildTree(arr)
print(bt.maxDepth(root))
