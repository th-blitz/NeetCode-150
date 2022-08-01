
from functools import lru_cache

def uniquePaths(m, n):
                
        @lru_cache(maxsize=None)
        def recur(x, y):
            
            if x == (m - 1) and y == (n - 1):
                return 1
            
            result = 0
            if x + 1 < m and y < n:
                result += recur(x + 1, y)
            if y + 1 < n and x < m:
                result += recur(x, y + 1)
            
            return result
                
        return recur(0, 0)


m = 14
n = 23

print("result : ", uniquePaths(m, n))