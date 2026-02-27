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
        if self.table[index] is None:
            self.table[index] = new_node
        else:
            curr = self.table[index]
            while curr.next:
                curr = curr.next
            curr.next = new_node
        print(f"Inserted: ({key},{value})")

    def retrieve(self, key):
        index = self.hash_func(key)
        curr = self.table[index]
        while curr:
            if curr.key == key:
                print(f"{key} -> {curr.value}")
                return
            curr = curr.next
    def display(self):
        for i in range(self.size):
            print(f"{i}:", end=" ")
            curr = self.table[i]
            if not curr:
                print("NULL")
            else:
                while curr:
                    print(f"({curr.key},{curr.value})->", end=" ")
                    curr = curr.next
                print("NULL")

ht = HashTable()
while True:
        op = int(input())
        if op == 1:
            key, value = map(int, input().split())
            ht.insert(key, value)
        elif op == 2:
            key = int(input())
            ht.retrieve(key)
        elif op == 3:
            ht.display()
        elif op == 4:
            print("Exit")
            break
