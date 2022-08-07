from functools import cache


def countVowelPermutation(n):
        
        vowels = {
            'a' : ['e'],
            'e' : ['a', 'i'],
            'i' : ['a', 'e', 'u', 'o'],
            'o' : ['i', 'u'],
            'u' : ['a']
        }
        
        # idx = {'a':0, 'e':1, 'i':2, 'o':3, 'u':4}
        # cache = [[0] * n for _ in vowels]
        
        @cache
        def recur(n, l):
            # if cache[idx[l]][n] > 0:
            #     return cache[idx[l]][n]
            if n == 0:
                return 1
            result = 0
            for v in vowels[l]:
                result += recur(n - 1, v)
            # cache[idx[l]][n] = result
            return result
        
        result = 0
        for v in vowels:
            result += recur(n - 1, v)
            
        return result % (10**9 + 7)


n = 100
print(f'n : {n} | result : {countVowelPermutation(n)}')
