

def isAnagram(s: str, t: str) -> bool:
        
        freq_map = [0] * 26
        
        idx = lambda x: ord(x) - 97
        
        for i in range(len(s)):
            freq_map[idx(s[i])] += 1
            
        for j in range(len(t)):
            freq_map[idx(t[j])] -= 1
        
        if [0] * 26 == freq_map:
            return True
        return False


def stdout(s, t):
    print(f's : {s}')
    print(f't : {t}')

    print(f'is anagram : {isAnagram(s, t)}')

s = "anagram"
t = "nagaram"

stdout(s, t)

s = "car"
t = "rat"

stdout(s, t)



