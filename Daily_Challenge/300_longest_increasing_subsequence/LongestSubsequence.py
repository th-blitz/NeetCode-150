


def lengthOfLIS(nums):
        
        memory = [0] * len(nums)
        
        def recur(index):
            if memory[index] > 0:
                return memory[index]
            max_depth = 0
            for i in range(index - 1, -1, -1):
                if nums[i] < nums[index]:
                    max_depth = max(max_depth, recur(i))
            memory[index] = max_depth + 1
            return memory[index]
        
        max_depth = 0
        for i in range(len(nums) - 1, -1, -1):
            max_depth = max(max_depth, recur(i))
        return max_depth


nums = [10,9,2,5,3,7,101,18]
print(f'nums : {nums} | result : {lengthOfLIS(nums)}')