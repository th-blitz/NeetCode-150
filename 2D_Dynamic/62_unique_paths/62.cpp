#include <vector>
using namespace std;

class Solution {
public:
    
    int recur(int x, int y, vector<vector<int>> &memory) {
        
            if (memory[x][y] > 0) {
                return memory[x][y];
            }
        
            if ((x == 0) && (y == 0)) {
                 return 1;
            }
               
            int result = 0;
            if ((x - 1 >= 0) && (y >= 0)) {
                result = result + recur(x - 1, y, memory);
            }
            if ((y - 1 >= 0) && (x >= 0)) {
                result = result + recur(x, y - 1, memory);
            }
        
            memory[x][y] = result;
        
            return result;
            
        }
    
    int uniquePaths(int m, int n) {
        
        vector<vector<int>> memory(m, vector<int>(n, 0));
        
        return recur(m - 1, n - 1, memory);
        
    }
};