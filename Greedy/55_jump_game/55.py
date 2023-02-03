

class Solution:
    def canJump(self, nums: List[int]) -> bool:

        # mem = [-1] * len(nums)
        # def recur(i):
        #     print(mem)
        #     if i >= len(nums) - 1:
        #         return True
        #     if mem[i] != -1:
        #         return mem[i]
        #     for j in range(1, nums[i] + 1):
        #         if recur(i + j) == True:
        #             mem[i] = True
        #             return True
        #     mem[i] = False
        #     return False

        good_position = len(nums) - 1
        for i in range(len(nums) - 1, -1, -1):
            if i + nums[i] >= good_position:
                good_position = i
            # for j in range(nums[i], 0, -1):
            #     if i + j >= len(nums) - 1 or dp[i + j] == 1:
            #         dp[i] = 1
            #         good_position = i
            #         break
        return good_position == 0