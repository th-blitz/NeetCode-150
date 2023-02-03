

def isPalindrome(s: str) -> bool:
        
        i = 0
        j = len(s) - 1
        
        while i < j:
            while i < j and s[i].isalnum() == False:
                i += 1
            while i < j and s[j].isalnum() == False:
                j -= 1
                
            if s[i].lower() != s[j].lower():
                return False
            
            i += 1
            j -= 1
        
        return True

s = "A man, a plan, a canal: Panama"

print("result : ", isPalindrome(s))