
class Solution:
    def countBits(self, n: int):
        result = [0] * (n + 1)
        for i in range(1, n + 1):
            result[i] = result[i & (i - 1)] + 1
        return result

