#include <vector>
#include <queue>
using namespace std;


class Solution {

private:
    
    struct SimpleHash {
        size_t operator()(const pair<int, int>& p) const {
            return p.first ^ p.second;
        }
    };
    
    vector<pair<int, int>> directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    void BFS(queue<pair<int, int>> &queue, vector<vector<bool>> &set, vector<vector<int>> &heights, int &rows, int &cols) {
        pair<int, int> coords;
        int a = 0;
        int b = 0;
        while (queue.empty() == false) {
            coords = queue.front();
            queue.pop();
            for (int i = 0; i < 4; i++) {
                a = directions[i].first + coords.first;
                b = directions[i].second + coords.second;        
                if (a >= 0 && a < rows && b >= 0 && b < cols && set[a][b] == false) {
                    if (heights[a][b] >= heights[coords.first][coords.second]) {
                        queue.push({a, b});
                        set[a][b] = true;
                    }
                }
            }
        }
    }

public:
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        
        int rows = heights.size();
        int cols = heights[0].size();
        
        queue<pair<int, int>> pacific;
        queue<pair<int, int>> atlantic;
        
        vector<vector<bool>> pacific_reach(rows, vector<bool>(cols, false));
        vector<vector<bool>> atlantic_reach(rows, vector<bool>(cols, false));
        
        int row;
        int col;
        
        for (row = 0; row < rows; row++) {
            pacific.push({row, 0});
            pacific_reach[row][0] = true;
            atlantic.push({row, cols - 1});
            atlantic_reach[row][cols - 1] = true;
        }
        for (col = 0; col < cols; col++) {
            pacific.push({0, col});
            pacific_reach[0][col] = true;
            atlantic.push({rows - 1, col});
            atlantic_reach[rows - 1][col] = true;
        }
        
        BFS(pacific, pacific_reach, heights, rows, cols);
        BFS(atlantic, atlantic_reach, heights, rows, cols);
        
        vector<vector<int>> result;
        for (row = 0; row < rows; row++) {
            for (col = 0; col < cols; col++) {
                if ( pacific_reach[row][col] && atlantic_reach[row][col] ) {
                    vector<int> coords = {row, col};
                    result.push_back(coords);
                }
            }
        }
        
        return result;
    }
};