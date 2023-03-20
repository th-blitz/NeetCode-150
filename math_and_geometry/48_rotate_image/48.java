/**
 * T: O(N ^ 2)
 * S: O(1)
 * See https://www.youtube.com/watch?v=fMSJSS7eO1w&t=927s video for good explanation
 */
class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        int left = 0;
        int right = n - 1;

        while (left < right) {

            for (int i = 0; i < right - left; i++) {

                int top = left, bottom = right;

                int temp = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = temp;
            }

            left++;
            right--;
        }
    }
}

/**
 * Rotate 90 degree = Transpose + Reverse
 * T: O(N ^ 2)
 * S: O(1)
 */
class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    public void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}