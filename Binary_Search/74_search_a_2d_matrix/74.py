

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        rows = len(matrix)
        cols = len(matrix[0])

        def recur(left, right):
            
            if left > right:
                return False
            
            mid = (left + right) // 2

            col = mid % cols
            row = mid // cols 

            if matrix[row][col] == target:
                return True
            
            if matrix[row][col] > target:
                return recur(left, mid - 1)
            return recur(mid + 1, right)
        
        return recur(0, (rows * cols) - 1)