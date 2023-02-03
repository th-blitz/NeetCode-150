

class Solution:
    def missingNumber(self, nums) -> int:
        
        result = 0
        for i, num in enumerate(nums):
            result ^= i ^ num
        return result ^ len(nums)