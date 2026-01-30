class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
class BST:
    def __init__(self):
        self.root = None
    def insert(self,data):
        if self.root is None:
            self.root= Node(data)
        else:
            self.insertRecursion(self.root,data)
    def insertRecursion(self,node,data):
        if data<node.data:
            if node.left is None:
                node.left=Node(data)
            else:
                self.insertRecursion(node.left,data)
        else:
            if node.right is None:
                node.right=Node(data)
            else:
                self.insertRecursion(node.right,data)

    def leftView(self):
        q = [self.root]
        result = []
        while q:
            level_size = len(q)
            for i in range(level_size):
                node = q.pop(0)
                if i == 0:
                    result.append((node.data))
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
        print(*result)

n = int(input())
bst = BST()
for i in range(n):
    keyword = input()
    bst.insert(keyword)
bst.leftView()
