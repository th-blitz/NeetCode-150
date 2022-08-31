

impl Solution {
    pub fn pacific_atlantic(heights: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let rows: usize = heights.len();
        let cols: usize = heights[0].len();
        
        let directions: Vec<(isize, isize)> = vec!((-1, 0), (1, 0), (0, 1), (0, -1));
        
        let mut pacific_reach: Vec<Vec<bool>> = vec![vec![false; cols]; rows];
        let mut atlantic_reach: Vec<Vec<bool>> = vec![vec![false; cols]; rows];
        
        
        fn dfs(row: usize, col: usize, set: &mut Vec<Vec<bool>>, heights: &Vec<Vec<i32>>, directions: &Vec<(isize, isize)>) {
            set[row][col] = true;
            for (mut a, mut b) in directions.iter() {
                a += row as isize;
                b += col as isize;
                if a >= 0 && a < heights.len() as isize && b >= 0 && b < heights[0].len() as isize && set[a as usize][b as usize] == false {
                    if heights[a as usize][b as usize] >= heights[row as usize][col as usize] {
                        dfs(a as usize, b as usize, set, heights, directions);
                    }
                }
            }
        }
        
        for row in 0..rows {
            dfs(row, 0, &mut pacific_reach, &heights, &directions);
            dfs(row, cols - 1, &mut atlantic_reach, &heights, &directions);
        }
        for col in 0..cols {
            dfs(0, col, &mut pacific_reach, &heights, &directions);
            dfs(rows - 1, col, &mut atlantic_reach, &heights, &directions);
        }
        
        let mut result: Vec<Vec<i32>> = Vec::new();
        for row in 0..rows {
            for col in 0..cols {
                if pacific_reach[row][col] && atlantic_reach[row][col] {
                    result.push(vec!(row as i32, col as i32));
                }
            }
        }
        return result;
    }
}

