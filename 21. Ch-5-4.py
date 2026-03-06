class TwoSum:
    def find_indices(self, arr, target):
        hashmap = {}
        print(f"Finding two indices whose values add up to {target}...")
        for i in range(len(arr)):
            x=arr[i]
            y = target - x
            if y in hashmap:
                print(f"Indices: {hashmap[y]} {i}")
                return
            hashmap[arr[i]] = i
        print("No solution found")

n = int(input().strip())
arr = list(map(int, input().split()))
target = int(input().strip())

finder = TwoSum()
finder.find_indices(arr, target)
