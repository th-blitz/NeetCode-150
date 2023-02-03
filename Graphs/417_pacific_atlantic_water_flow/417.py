from collections import deque


class Solution:
    def pacificAtlantic(self, heights):
        
        rows = len(heights)
        cols = len(heights[0])
        
        directions = ((-1, 0), (1, 0), (0, 1), (0, -1))
        
        pacific = deque()
        atlantic = deque()
        for row in range(rows):
            pacific.append((row, 0))
            atlantic.append((row, cols - 1))
        for col in range(cols):
            pacific.append((0, col))
            atlantic.append((rows - 1, col))
            
    
        def bfs(queue):
            seen = set()
            while queue:
                x, y = queue.popleft()
                seen.add((x, y))
                for a, b in directions:
                    a += x
                    b += y
                    if a >= 0 and a < rows and b >= 0 and b < cols and (a, b) not in seen:
                        if heights[a][b] >= heights[x][y]:
                            queue.append((a, b))
            return seen
        
        pacific_reach = bfs(pacific)
        atlantic_reach = bfs(atlantic)
        
        res = []
        for a, b in pacific_reach:
            if (a, b) in atlantic_reach:
                res.append([a, b])
                
        return res