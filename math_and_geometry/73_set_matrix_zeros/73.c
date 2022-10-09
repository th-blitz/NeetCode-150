

void setZeroes(int** matrix, int matrixSize, int* matrixColSize){
    
    int rows = matrixSize;
    int cols = *matrixColSize;
    bool first_zero = false;

    for (int row = 0; row < rows; row++) {
        if (matrix[row][0] == 0) {
            first_zero = true;
        }
        for (int col = 1; col < cols; col++) {
            if (matrix[row][col] == 0) {
                matrix[row][0] = 0;
                matrix[0][col] = 0;
            }
        }
    }

    for (int row = 1; row < rows; row++) {
        for (int col = 1; col < cols; col++) {
            if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                matrix[row][col] = 0;
            }
        }
    }
    if (matrix[0][0] == 0) {
        for (int col = 0; col < cols; col++) {
            matrix[0][col] = 0;
        }
    }
    if (first_zero == true) {
        for (int row = 0; row < rows; row++) {
            matrix[row][0] = 0;
        }
    }
}