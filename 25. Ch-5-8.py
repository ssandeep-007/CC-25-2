import heapq

class Node:
    def __init__(self, ch, freq):
        self.ch = ch
        self.freq = freq
        self.left = None
        self.right = None

    # heap comparison
    #__lt__ means "less than" (in-built dunder method)
    #here __lt__ is used to compare the Node-objects
    def __lt__(self, other):    
        if self.freq == other.freq:
            return self.ch < other.ch
        return self.freq < other.freq

class HuffmanCoding:
    def __init__(self, chars, freq):
        self.chars = chars
        self.freq = freq
        self.root = None
        self.codes = {}

    def buildTree(self):
        heap = []
        for i in range(len(self.chars)):
            heapq.heappush(heap, Node(self.chars[i], self.freq[i]))

        while len(heap) > 1:
            left = heapq.heappop(heap)
            right = heapq.heappop(heap)
            merged = Node('$', left.freq + right.freq)
            merged.left = left
            merged.right = right
            heapq.heappush(heap, merged)
        self.root = heap[0]

    def generateCodes(self, node, code):
        if not node:
            return
        if node.left is None and node.right is None:
            self.codes[node.ch] = code
            return
        self.generateCodes(node.left, code + "0")
        self.generateCodes(node.right, code + "1")

    def display(self):
        print("Huffman Codes:")
        for ch in self.chars:
            print(f"{ch}: {self.codes[ch]}")

#Main────────────────────────────────────────
n = int(input())
chars = input().split()
freq = list(map(int, input().split()))

huffman = HuffmanCoding(chars, freq)

huffman.buildTree()
huffman.generateCodes(huffman.root, "")
huffman.display()
