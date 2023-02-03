

class Solution:
    def hammingWeight(self, n) -> int:
        sum = 0
        while n != 0:
            sum += 1
            n &= n - 1
        return sum 