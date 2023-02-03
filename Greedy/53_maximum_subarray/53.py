
def maxSubArray(nums):
        
    current_sum = nums[0]
    max_sum = nums[0]
    
    for i in range(1, len(nums)):
        if current_sum < 0:
            current_sum = nums[i]
        else:
            current_sum += nums[i]
        
        if max_sum < current_sum:
            max_sum = current_sum
        
    return max_sum