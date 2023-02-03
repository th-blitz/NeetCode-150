

class Solution:
    def subsets(self, nums):
        
        subsets = [[]]
        for num in nums:
            subsets += [current + [num] for current in subsets]
        
        return subsets