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
        if arr[self.idx] == -1:
            self.idx += 1
            return None
        root = Node(arr[self.idx])
        self.idx += 1
        root.left = self.build_tree(arr)
        root.right = self.build_tree(arr)
        return root
#Main__________________
arr1 = list(map(int, input().split()))
arr2 = list(map(int, input().split()))
bt1 = BuildTree()
bt2 = BuildTree()
root1 = bt1.build_tree(arr1)
root2 = bt2.build_tree(arr2)
def is_mirror(root1, root2):
    if root1 is None and root2 is None:
        return True
    if root1 is None or root2 is None:
        return False
    if root1.data != root2.data:
        return False
    return (is_mirror(root1.left, root2.right) and
            is_mirror(root1.right, root2.left))

if is_mirror(root1, root2):
    print("The two trees are mirrors of each other.")
else:
    print("The two trees are not mirrors of each other.")
