

class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        
        result = []
        n = 1
            
        for x in reversed(digits):
            res = x + n
            result.append(res%10)
            n = res//10
        if n != 0:
            result.append(n)
        return reversed(result)