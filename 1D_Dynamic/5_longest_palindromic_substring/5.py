
# dynamic solution - recursion:
class Solution:
    def longestPalindrome(self, s: str) -> str:

        dp = [[None] * len(s) for _ in range(len(s))]

        def is_palindrome(i, j):
            if dp[i][j] != None:
                return dp[i][j]
            if i >= j:
                return True
            dp[i][j] = s[i] == s[j] and is_palindrome(i + 1, j - 1)
            return dp[i][j]

        result = [0, 0]
        max_len = 0
        for x in range(len(s)):
            i = 0
            for j in range(x, len(s)):
                if is_palindrome(i, j) and j - i + 1 > max_len:
                    max_len = j - i + 1
                    result[0] = i
                    result[1] = j
                i += 1
        
        return s[result[0]: result[1] + 1]


# search from center solution:
class Solution:
    def longestPalindrome(self, s: str) -> str:

        def is_palindrome(i, j):
            while i >= 0 and j >= 0 and i < len(s) and j < len(s) and s[i] == s[j]:
                i -= 1
                j += 1
            return (i, j)

        max_len = 0
        result = [0, 0]
        for i in range(len(s)):
            x, y = is_palindrome(i, i)
            if y - x - 1 > max_len:
                max_len = y - x - 1
                result[0] = x + 1
                result[1] = y
        
        for j in range(1, len(s)):
            x, y = is_palindrome(j - 1, j)
            if y - x - 1 > max_len:
                max_len = y - x - 1
                result[0] = x + 1
                result[1] = y
            
        return s[result[0]: result[1]]
        
                
        
                