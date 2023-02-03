

class Solution:
    def rob(self, nums) -> int:
        
        if len(nums) == 1:
            return nums[0]
        
        nums[1] = max(nums[0], nums[1])
        for i in range(2, len(nums)):
            nums[i] = max(nums[i - 1], nums[i] + nums[i - 2])
        return max(nums[-1], nums[-2])
        