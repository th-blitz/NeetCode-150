

def search(nums, target):
        
        left = 0
        right = len(nums) - 1
        
        def BinarySearch(nums, left, right):
            
            if left>right:
                return -1
            
            if nums[left] == target:
                return left
            elif nums[right] == target:
                return right
            
            mid = (left + right) // 2
            
            if nums[mid] == target:
                return mid
            
            if nums[mid] < target:
                return BinarySearch(nums, mid+1, right)
            else:
                return BinarySearch(nums, left, mid-1)
            
        return BinarySearch(nums, left, right)


nums = [-1, 0, 3, 5, 9, 12]
target = 9

print(f"nums : {nums}, target : {target}, result : {search(nums, target)}")