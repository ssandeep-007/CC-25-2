class TrieNode:
    def __init__(self):
        self.children = {}
        self.flag = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for ch in word:
            if ch not in node.children:
                node.children[ch] = TrieNode()
            node = node.children[ch]
        node.flag = True
        print(f"Inserted: {word}")

    def search(self, word):
        node = self.root
        for ch in word:
            if ch not in node.children:
                return False
            node = node.children[ch]
        if node.flag:
            return True
        else:
            return False

    def remove(self, word):
        if not self.search(word):
            print(f"Not found: {word}")
            return
        self.removeRecursion(self.root, word, 0)
        print(f"Removed: {word}")

    def removeRecursion(self, node, word, index):
        if index == len(word):
            node.flag = False
            return len(node.children) == 0
        ch = word[index]
        deleteChild = self.removeRecursion(node.children[ch], word, index + 1)

        if deleteChild:
            del node.children[ch]
            return not node.flag and len(node.children) == 0
        return False

# -------- MAIN --------
trie = Trie()

while True:
    op = int(input())
    if op == 1:
        word = input()
        trie.insert(word)
    elif op == 2:
        word = input()
        res=trie.search(word)
        if res:
            print(f"Found: {word}")
        else:
            print(f"Not found: {word}")
    elif op == 3:
        word = input()
        trie.remove(word)
    elif op == 4:
        break
