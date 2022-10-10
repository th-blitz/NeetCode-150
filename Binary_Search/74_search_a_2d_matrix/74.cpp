

class Solution {
public:

    bool recur(vector<vector<int>> &matrix, int left, int right, int target) {
        
        if (left > right) {
            return false;
        }

        int mid = (int)((left + right) / 2);

        int col = mid % matrix[0].size();
        int row = (int)(mid / matrix[0].size());

        if (matrix[row][col] == target) {
            return true;
        }

        if (matrix[row][col] > target) {
            return recur(matrix, left, mid - 1, target);
        }
        return recur(matrix, mid + 1, right, target);
    }

    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        return recur(matrix, 0, (matrix.size() * matrix[0].size()) - 1, target);
    }
};