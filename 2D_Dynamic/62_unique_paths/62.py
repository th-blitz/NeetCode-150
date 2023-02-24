
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        
        
        @cache
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