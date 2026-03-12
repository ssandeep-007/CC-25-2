class TrieNode:
    def __init__(self):
        self.children = {}
        self.flag = False

class Trie:
    def __init__(self):
        self.root = TrieNode()
        self.count = 0

    def insert(self, word):
        node = self.root
        for ch in word:
            if ch not in node.children:
                node.children[ch] = TrieNode()
            node = node.children[ch]
        if not node.flag:
            node.flag = True
            self.count += 1

    def UniqueWords(self):
        return self.count

n = int(input())
trie = Trie()
for i in range(n):
    trie.insert(input())
print(trie.UniqueWords())
