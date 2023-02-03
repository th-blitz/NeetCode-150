
class Solution:
    def isHappy(self, n: int) -> bool:
        
        def getNextNum(num):
            next_num = 0
            while num != 0:
                next_num += (num % 10) ** 2
                num = num // 10
            return next_num
        
        hashset = set()
        
        while True:
            
            n = getNextNum(n)
            if n == 1:
                return True
            if n in hashset:
                return False
            hashset.add(n)
            
        