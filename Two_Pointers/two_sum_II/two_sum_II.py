

def twoSum(numbers, target):
        
        i = 0
        j = len(numbers) - 1
        
        while i < j:
            
            if (numbers[i] + numbers[j]) == target:
                return [i+1, j+1]
            
            if (numbers[i] + numbers[j]) < target:
                i += 1
            else:
                j -= 1
        
        return [-1, -1]


numbers = [2, 7, 11, 15]
target = 9

res = twoSum(numbers, target)
print('result : ', res)