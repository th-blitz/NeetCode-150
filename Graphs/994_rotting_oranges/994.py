class Solution:
    def orangesRotting(self, grid) -> int:
        
        row_len = len(grid)
        col_len = len(grid[0])
        
        queue = []
        minutes = set()
        
        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        
        def DFS(queue):
            
            minutes.clear()

            while queue:
                row, col, minute = queue.pop(0)
                minutes.add(minute)
                for dirct in directions:
                    r = row + dirct[0]
                    c = col + dirct[1]

                    if r >= 0 and r < row_len and c >= 0 and c < col_len and grid[r][c] == 1:
                        queue.append([r, c, minute + 1])
                        grid[r][c] = 0
            
            if len(minutes) == 0:
                return 0
            return max(minutes)
                
        
        for i in range(row_len):
            for j in range(col_len):
                if grid[i][j] == 2:
                    queue.append([i, j, 0])
                    
        time = DFS(queue)
        
        for rows in grid:
            if 1 in rows:
                return -1
        
        return time