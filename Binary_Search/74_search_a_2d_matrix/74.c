


bool recur(int** matrix, int left, int right, int target, int cols) {
    
    if (left > right) {
        return false;
    }

    int mid = (int)((left + right) / 2);

    int col = mid % cols;
    int row = (int)(mid / cols);

    if (matrix[row][col] == target) {
        return true;
    }

    if (matrix[row][col] > target) {
        return recur(matrix, left, mid - 1, target, cols);
    }
    return recur(matrix, mid + 1, right, target, cols);
}


bool searchMatrix(int** matrix, int matrixSize, int* matrixColSize, int target){
    return recur(matrix, 0, (matrixSize * *matrixColSize) - 1, target, *matrixColSize);
}