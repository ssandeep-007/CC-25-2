class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


class BuildTree:
    def __init__(self):
        self.idx = 0

    def build_tree(self, arr):
        if self.idx >= len(arr):
            return None

        if  arr[self.idx] == -1:
            self.idx+=1
            return None

        root = Node(arr[self.idx])
        self.idx += 1

        root.left = self.build_tree(arr)
        root.right = self.build_tree(arr)

        return root

    def preorder(self, root):
        if root is None:
            return
        print(root.data, end=" ")
        self.preorder(root.left)
        self.preorder(root.right)

    def inorder(self, root):
        if root is None:
            return
        self.inorder(root.left)
        print(root.data, end=" ")
        self.inorder(root.right)

    def postorder(self, root):
        if root is None:
            return
        self.postorder(root.left)
        self.postorder(root.right)
        print(root.data, end=" ")


import sys
arr = list(map(int, sys.stdin.read().split()))
bt = BuildTree()
root = bt.build_tree(arr)
bt.preorder(root)
print()
bt.inorder(root)
print()
bt.postorder(root)
