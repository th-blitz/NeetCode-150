


impl Solution {
    pub fn search_matrix(matrix: Vec<Vec<i32>>, target: i32) -> bool {
        let cols: usize = matrix[0].len();
        let mut row: usize;
        let mut col: usize;
        let mut left: usize = 0;
        let mut right: usize = (matrix.len() * matrix[0].len()) - 1;
        let mut mid: usize;
        while left <= right {
            mid = (left + right) / 2;
            col = mid % cols;
            row = mid / cols;
            if matrix[row][col] == target {
                return true;
            }
            if matrix[row][col] > target {
                if mid > 0 {
                    right = mid - 1; 
                } else {
                    break;
                }
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}