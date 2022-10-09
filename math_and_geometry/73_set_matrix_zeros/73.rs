

impl Solution {
    pub fn set_zeroes(matrix: &mut Vec<Vec<i32>>) {
        
        let rows: usize = matrix.len();
        let cols: usize = matrix[0].len();
        let mut first_col: bool = false;

        for row in 0..rows {
            if matrix[row][0] == 0 {
                first_col = true;
            }
            for col in 1..cols {
                if matrix[row][col] == 0 {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for row in 1..rows {
            for col in 1..cols {
                if matrix[row][0] == 0 || matrix[0][col] == 0 {
                    matrix[row][col] = 0;
                }
            }
        }

        if matrix[0][0] == 0 {
            for col in 0..cols {
                matrix[0][col] = 0;
            }
        }

        if first_col == true {
            for row in 0..rows {
                matrix[row][0] = 0;
            }
        }

    }
}