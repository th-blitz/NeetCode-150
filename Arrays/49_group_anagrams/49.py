
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        hashmap = defaultdict(list)
        anagram = [0] * 26
        idx = lambda x: ord(x) - 97
        for s in strs:
            for char in s:
                anagram[idx(char)] += 1
            hashmap[tuple(anagram)].append(s)
            for i in range(26):
                anagram[i] = 0

        return hashmap.values()
        