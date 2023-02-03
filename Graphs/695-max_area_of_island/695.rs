
use std::cmp::max;

impl Solution {
    
    pub fn max_area_of_island(grid: Vec<Vec<i32>>) -> i32 {
        let rows: usize = grid.len();
        let cols: usize = grid[0].len();
        let mut max_area: usize = 0;
        let mut grid = grid;
        
        fn dfs(x: usize, y: usize, grid: &mut Vec<Vec<i32>>) -> usize {
            grid[x][y] = 0;
            let mut area: usize = 1;
            if x + 1 < grid.len() && grid[x + 1][y] == 1 {
                area += dfs(x + 1, y, grid);
            } 
            if x > 0 && grid[x - 1][y] == 1 {
                area += dfs(x - 1, y, grid);
            }
            if y + 1 < grid[0].len() && grid[x][y + 1] == 1 {
                area += dfs(x, y + 1, grid);
            }
            if y > 0 && grid[x][y - 1] == 1 {
                area += dfs(x, y - 1, grid);
            } 
            return area;
        }
        
        for row in 0..rows {
            for col in 0..cols {
                if grid[row][col] == 1 {
                    max_area = max(max_area, dfs(row, col, &mut grid));
                }
            }
        }
        return max_area as i32;
    }
}