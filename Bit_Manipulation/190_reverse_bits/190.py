

class Solution:
    def reverseBits(self, n: int) -> int:
        result, power = 0, 31
        while n:
            result += (n & 1) << power
            n = n >> 1
            power -= 1
        return result