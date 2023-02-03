

class Solution:
    def rob(self, nums) -> int:
        
        if len(nums) == 1:
            return nums[0]

        def robbing(nums, i, j):
            first = 0
            second = 0
            for i in range(i, j):
                first, second = max(nums[i] + second, first), first
            return first
        
        return max(robbing(nums, 1, len(nums)), robbing(nums, 0, len(nums) - 1))