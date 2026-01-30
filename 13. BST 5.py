class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
class BinaryTree:
    def __init__(self):
        self.idx = 0
    def build_tree(self, arr):
        if self.idx >= len(arr):
            return None
        if arr[self.idx] == -1:
            self.idx+=1
            return None
        root = Node(arr[self.idx])
        self.idx += 1
        root.left = self.build_tree(arr)
        root.right = self.build_tree(arr)
        return root

    def level_order(self, root):
        q = []
        q.append(root)
        result = []
        while q:
            node = q.pop(0)
            result.append((node.data))
            if node.left:
                q.append(node.left)
            if node.right:
                q.append(node.right)
        print(*result)

import sys
arr = []
arr = list(map(int, sys.stdin.read().split()))
bt = BinaryTree()
root = bt.build_tree(arr)
bt.level_order(root)
