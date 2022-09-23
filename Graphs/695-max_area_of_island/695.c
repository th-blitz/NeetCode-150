


int directions[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

int dfs(int x, int y, int** grid, int rows, int cols) {
    grid[x][y] = 0;
    int a;
    int b;
    int area = 1;
    for (int i = 0; i < 4; i++) {
        a = x + directions[i][0];
        b = y + directions[i][1];
        if ((a >= 0) && (b >= 0) && (a < rows) && (b < cols) && (grid[a][b] == 1)) {
            area += dfs(a, b, grid, rows, cols);
        }
    }
    return area;
}

int max(int a, int b) {
    if (a > b) {
        return a;
    }
    return b;
}

int maxAreaOfIsland(int** grid, int gridSize, int* gridColSize){
    
    int rows = gridSize;
    int cols = gridColSize[0];
    int max_area = 0;
    
    for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
            if (grid[row][col] == 1) {
                max_area = max(max_area, dfs(row, col, grid, rows, cols));
            }
        }
    }
    return max_area;
}