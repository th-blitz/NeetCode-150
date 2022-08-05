from functools import lru_cache

def combinationSum4(nums, target):
        
        @lru_cache(10_000)
        def recur(target):
            
            if target == 0:
                return 1
            if target < 0:
                return 0
            
            result = 0
            for num in nums:
                result += recur(target - num)
            return result
        
        return recur(target)


nums = [1,2,3,8,7,5,9]
target = 10

print(f"nums : {nums}, target : {target} | result : {combinationSum4(nums, target)}")