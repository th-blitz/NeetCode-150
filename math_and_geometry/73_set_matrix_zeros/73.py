

class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        
        rows = len(matrix)
        cols = len(matrix[0])
        
        set_rows = set()
        set_cols = set()
        for row in range(rows):
            for col in range(cols):
                if matrix[row][col] == 0:
                    set_rows.add(row)
                    set_cols.add(col)
        
        for row in set_rows:
            for j in range(cols):
                matrix[row][j] = 0
            
        for col in set_cols:
            for i in range(rows):
                matrix[i][col] = 0

        """
        Do not return anything, modify matrix in-place instead.
        """