

fn dfs(row: isize, col: isize, grid: &mut Vec<Vec<char>>, directions: &Vec<(isize, isize)>) {
    
    for dir in directions {
        let r = row as isize + dir.0;
        let c = col as isize + dir.1;
        if r >= 0 && r < grid.len() as isize && c >= 0 && c < grid[0].len() as isize && grid[r as usize][c as usize] == '1' {
            grid[r as usize][c as usize] = '0';
            dfs(r, c, grid, directions);
        }
    }
}


impl Solution {
    pub fn num_islands(grid: Vec<Vec<char>>) -> i32 {
        
        let directions: Vec<(isize, isize)> = vec!((1, 0), (-1, 0), (0, 1), (0, -1));
        
        let rows: usize = grid.len();
        let cols: usize = grid[0].len();
        
        let mut Islands: i32 = 0;
        
        let mut copygrid = grid;
        
        for row in 0..rows {
            for col in 0..cols {
                if copygrid[row][col] == '1' {
                    dfs(row as isize, col as isize, &mut copygrid, &directions);
                    Islands += 1;
                }
            }
        }
        return Islands;
    }
}