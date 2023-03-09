

class Solution:
    def getSum(self, a: int, b: int) -> int:
        mask = 0xffffffff

        while b != 0:
            a, b = (a ^ b) & mask, ((a & b) << 1) & mask
        
        maxint = 0x7fffffff
        return a if a < maxint else ~(a ^ mask)
        
    

