

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:

        results = []
        def backtrack(combination = deque(), running_sum = 0, start = 0):
            if running_sum == target:
                results.append(list(combination))
                return
            if running_sum < target:
                for i in range(start, len(candidates)):
                    combination.append(candidates[i])
                    backtrack(combination, running_sum + candidates[i], i)
                    combination.pop()
            return
        
        backtrack()
        return results
            