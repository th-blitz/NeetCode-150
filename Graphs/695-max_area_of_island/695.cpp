#include <vector>
using namespace std;

class Solution {

public:
    
    vector<vector<int>> directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    int dfs(int x, int y, vector<vector<int>> &grid) {
        grid[x][y] = 0;
        int a = 0;
        int b = 0;
        int area = 1;
        for (int i = 0; i < directions.size(); i++) {
            a = x + directions[i][0];
            b = y + directions[i][1];
            if ((a >= 0) && (b >= 0) && (a < grid.size()) && (b < grid[0].size()) && (grid[a][b] == 1)) {
                area += dfs(a, b, grid);
            }
        }
        return area;
    }
    
    int max(int a, int b) {
        if (a > b) return a;
        return b;
    }
    
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        
        int rows = grid.size();
        int cols = grid[0].size();
        int max_area = 0;
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    max_area = max(max_area, dfs(row, col, grid));
                }
            }
        }
        
        return max_area;
        
    }
};