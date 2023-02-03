from collections import deque


class Solution:
    def maxAreaOfIsland(self, grid) -> int:
        
        directions = ((1, 0), (-1, 0), (0, 1), (0, -1))
        m = len(grid)
        n = len(grid[0])
        
        
        def DFS(row, col):
            
            queue = deque()
            queue.append((row, col))
            grid[row][col] = 0
            area = 1
            
            while queue:
                
                row , col = queue.popleft()
                
                for i, j in directions:
                    r = row + i
                    c = col + j
                    
                    if r < m and c < n and r >= 0 and c >= 0 and grid[r][c] == 1:
                        queue.append((r, c))
                        grid[r][c] = 0
                        area += 1
                        
            return area
        
        max_area = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    max_area = max(max_area, DFS(i, j))
                    
        return max_area
        