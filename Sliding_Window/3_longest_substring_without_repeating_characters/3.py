


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        window = [0] * 96
        index = lambda x: ord(x) - 33
        max_count = 0
        count = 0
        i = 0
        j = 0
        while j < len(s):
            if i == j or window[index(s[j])] == 0:
                window[index(s[j])] = 1
                count += 1
                max_count = max(count, max_count)
                j += 1
            else:
                window[index(s[i])] = 0
                count -= 1
                i += 1
        
        return max_count
