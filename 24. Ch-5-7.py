class TrieNode:
    def __init__(self):
        self.children = {}

class DistinctSubstrings:
    def __init__(self):
        self.root = TrieNode()
    def count_subStrings(self, text):
        count = 0
        n = len(text)
        for i in range(n):
            node = self.root
            for j in range(i, n):
                ch = text[j]
                if ch not in node.children:
                    node.children[ch] = TrieNode()
                    count += 1
                node = node.children[ch]
        return count

s = input()
ob = DistinctSubstrings()
print(ob.count_subStrings(s))
