#include <vector>
using namespace std;



class Solution {

private:
    
    vector<vector<int>> directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    void dfs(int row, int col, vector<vector<char>> &grid) {
        
        int r;
        int c;
        
        for (int j = 0; j < directions.size(); j++) {
            r = row + directions[j][0];
            c = col + directions[j][1];
            if (r >= 0 && r < grid.size() && c >= 0 && c < grid[0].size() && grid[r][c] == '1') {
                grid[r][c] = '0'; 
                dfs(r, c, grid);
            }
        }
        
    }
    
public:
    int numIslands(vector<vector<char>>& grid) {
        
        int rows = grid.size();
        int cols = grid[0].size();
        
        int IslandCount = 0;
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    dfs(row, col, grid);
                    IslandCount++;
                }
            }
        }
        return IslandCount;
        
    }
};