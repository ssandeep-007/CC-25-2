#bst2

class Node:
    def __init__(self,x):
        self.data=x
        self.left=None
        self.right=None

class BinaryTree:
    def __init__(self):
        self.idx=0
    def buildTree(self,arr):
        if self.idx >= len(arr) or arr[self.idx]==-1:
            self.idx+=1
            return None
        node= Node(arr[self.idx])
        self.idx+=1

        node.left= self.buildTree(arr)
        node.right= self.buildTree(arr)
        return node

    def validateBST(self,node,minVal,maxVal):
        if node is None:
            return True
        if node.data<=minVal or node.data>=maxVal:
            return False
        return (self.validateBST(node.left,minVal,node.data) 
            and self.validateBST(node.right,node.data,maxVal))

line1=list(map(int,input().split()))
tree=BinaryTree()
root= tree.buildTree(line1)
res=tree.validateBST(root,float('-inf'), float('inf'))
print(res)
