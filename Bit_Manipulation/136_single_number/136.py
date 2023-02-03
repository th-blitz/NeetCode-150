

from re import A


class Solution:
    def singleNumber(nums):
        a = 0
        for b in nums:
            a ^= b
        return a 

