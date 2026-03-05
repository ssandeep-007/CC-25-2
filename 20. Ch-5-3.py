class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None

class HashTable:
    def __init__(self):
        self.size = 10
        self.table = [None] * self.size
    def hash_func(self, key):
        return key % self.size

    def insert(self, key, value):
        index = self.hash_func(key)
        new_node = Node(key, value)
        new_node.next = self.table[index]
        self.table[index] = new_node
        print(f"Inserted: ({key},{value})")

    def delete(self, key):
        index = self.hash_func(key)
        curr = self.table[index]
        prev = None
        while curr:
            if curr.key == key:
                if prev is None:
                    self.table[index] = curr.next
                else:
                    prev.next = curr.next
                curr.next=None
                print(f"Key {key} deleted successfully.")
                return
            prev = curr
            curr = curr.next
        print(f"Key {key} not found.")
    def retrieve(self, key):
        index = self.hash_func(key)
        curr = self.table[index]
        while curr:
            if curr.key == key:
                print(f"{key} -> {curr.value}")
                return
            curr = curr.next
        print(f"Key {key} not found.")

    def display(self):
        for i in range(self.size):
            if self.table[i]:
                print(f"Index {i}:", end=" ")
                curr = self.table[i]
                while curr:
                    print(f"({curr.key},{curr.value})", end=" ")
                    curr = curr.next
                print()

ht = HashTable()
while True:
    op = int(input())
    if op == 1:
        key, value = map(int, input().split())
        ht.insert(key, value)
    elif op == 2:
        key = int(input())
        ht.delete(key)
    elif op == 3:
        key = int(input())
        ht.retrieve(key)
    elif op == 4:
        ht.display()
    elif op == 5:
        print("Exit")
        break
