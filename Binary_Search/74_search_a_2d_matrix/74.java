/**
 * Doing binary search on the 1st column to figure out which row to search for,
 * then do binary search on that row to find the element.
 * T: O(log (m * n))
 * S: O(1)
 */
// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {

//         if (matrix == null || matrix.length == 0) return false;

//         int low = 0, high = matrix.length - 1;

//         int row = 0;

//         while (low < high) {
//             int mid = low + (high - low) / 2;

//             if (matrix[mid][0] < target) {
//                 low = mid + 1;
//             } else {
//                 high = mid;
//             }
//         }


//         if (matrix[low][0] == target) return true;
//         else if (matrix[low][0] < target) {
//             row = low;
//         } else if (low != 0) {
//             row = low - 1;
//         }

//         low = 0;
//         high = matrix[row].length - 1;

//         while (low <= high) {
//             int mid = low + (high - low) / 2;

//             if (matrix[row][mid] == target) {
//                 return true;
//             } else if (matrix[row][mid] < target) {
//                 low = mid + 1;
//             } else {
//                 high = mid - 1;
//             }
//         }

//         return false;
//     }
// }

/**
 * The matrix can be thought like a virtual array.
 * T: O(log (m * n))
 * S: O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int pivotElement = matrix[mid / n][mid % n];
            if (target == pivotElement) return true;
            else if (pivotElement < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}