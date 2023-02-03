

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:

        chessboard = [[0] * n for _ in range(n)]
        result = []
        

        def toggle_queen(row, col, chessboard, place = 1):
            
            chessboard[row][col] -= place

            for i in range(0, n):
                if i != col:
                    chessboard[row][i] += place 
            for j in range(0, n):
                if j != row:
                    chessboard[j][col] += place
            
            for x, y in ((1, -1), (1, 1), (-1, 1), (-1, -1)):   
                i = row + x
                j = col + y
                while i >= 0 and i < n and j >= 0 and j < n:
                    chessboard[i][j] += place
                    i += x
                    j += y        
                    
        def string(chessboard):
            board = []
            for row in range(n):
                board.append("")
                for col in range(n):
                    if chessboard[row][col] == -1:
                        board[row] += 'Q'
                    else:
                        board[row] += '.'
            return board

        def backtrack(row, chessboard):
            if row == n:
                result.append(string(chessboard))
                return
            
            for col in range(0, n):
                if chessboard[row][col] == 0:
                    toggle_queen(row, col, chessboard, 1)
                    backtrack(row + 1, chessboard)
                    toggle_queen(row, col, chessboard, -1)
            
            return
        
        backtrack(0, chessboard)
        return result