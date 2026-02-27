import heapq

class MaxProduct:
    def find_max_product(self, arr):
        unique_set = set(arr)
        if len(unique_set) < 3:
            return -1

        min_heap = []
        for num in unique_set:
            heapq.heappush(min_heap, num)
            if len(min_heap) > 3:
                heapq.heappop(min_heap)
        product = 1
        while min_heap:
            product *= heapq.heappop(min_heap)
        return product

n = int(input())
arr = list(map(int, input().split()))
ob1 = MaxProduct()
print(ob1.find_max_product(arr))
